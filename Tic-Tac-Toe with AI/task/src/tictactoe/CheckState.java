package tictactoe;

import java.util.Arrays;

public class CheckState {
    String notFinished = "Game not finished";
    String draw = "Draw";
    String xWins = "X wins";
    String oWins = "O wins";
    String impossible = "Impossible";

    public CheckState () {
        this.notFinished = notFinished;
        this.draw = draw;
        this.xWins = xWins;
        this.oWins = oWins;
        this.impossible = impossible;
    }

    public void figureOutAndPrintState (String[][] array){
        int amountOfXRows = howManyXOLines(array,"X");
        int amountOfORows = howManyXOLines(array,"O");
        int amountOfXColumns = howManyXOColumns(array, "X");
        int amountOfOColumns = howManyXOColumns(array,"O");
        int amountOfXDiagonals = howManyXODiagonals(array, "X");
        int amountOfODiagonals = howManyXODiagonals(array,"O");
        int amountOfX = countXOEmpty(array, "X");
        int amountOfO = countXOEmpty(array, "O");
        int amountOfEmpty = countXOEmpty(array, " ");
        if ((amountOfXRows>0 || amountOfXColumns>0 || amountOfXDiagonals>0) && (amountOfORows>0 || amountOfOColumns>0 || amountOfODiagonals>0)){
            System.out.println(impossible);
            return;
        }else if ((amountOfX - amountOfO) >=2 || (amountOfO - amountOfX) >=2 ){
            System.out.println(impossible);
        }else if (amountOfXRows == 0 && amountOfXColumns == 0 && amountOfXDiagonals ==0 && amountOfORows == 0 && amountOfOColumns == 0 && amountOfODiagonals == 0 && amountOfEmpty == 0){
            System.out.println(draw);
        }else if (amountOfXRows == 0 && amountOfXColumns == 0 && amountOfXDiagonals ==0 && amountOfORows == 0 && amountOfOColumns == 0 && amountOfODiagonals == 0 && amountOfEmpty >0){
            System.out.println(notFinished);
        }else if ((amountOfXRows>0 || amountOfXColumns>0 || amountOfXDiagonals>0) && (amountOfORows==0 || amountOfOColumns==0 || amountOfODiagonals==0)){
            System.out.println(xWins);
        }else if ((amountOfXRows==0 || amountOfXColumns==0 || amountOfXDiagonals==0) && (amountOfORows>0 || amountOfOColumns>0 || amountOfODiagonals>0)){
            System.out.println(oWins);
        }
        /*System.out.println(amountOfXRows + " - amount of X rows");
        System.out.println(amountOfORows + " - amount of O rows");
        System.out.println(amountOfXColumns + " - amount of X columns");
        System.out.println(amountOfOColumns + " - amount of O columns");
        System.out.println(amountOfXDiagonals + " - amount of X diagonals");
        System.out.println(amountOfODiagonals + " - amount of O diagonals");
        System.out.println(amountOfX + " - amount of X");
        System.out.println(amountOfO + " - amount of O");
        System.out.println(amountOfEmpty + " - amount of empty");*/
    }

    public int countXOEmpty (String [][] array, String symbol){
        int counter = 0;
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                if (symbol.equals(array[i][j])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int howManyXODiagonals (String[][] array, String symbol){
        int diagonals = 0;
        int inDiagonal = 0;
        int diagonalBackwardCounter = 2;

        for (int i = 0; i <3; i++){
            if (symbol.equals(array[i][i])){
                inDiagonal++;
            }
        }
        if (inDiagonal == 3){
            diagonals++;
        }
        inDiagonal = 0;
        for (int i = 0; i <3; i++ ){
            if (symbol.equals(array[i][diagonalBackwardCounter])){
                inDiagonal++;
            }
            diagonalBackwardCounter--;
        }
        if (inDiagonal == 3){
            diagonals++;
        }
        return diagonals;
    }

    public int howManyXOLines (String [][] array, String symbol) {
        int lines = 0;
        int inLines;

        for (int i = 0; i < 3; i++) {
            inLines = 0;
            for (int j = 0; j < 3; j++) {
                if (symbol.equals(array[i][j])) {
                    inLines++;
                }
                if (inLines == 3) {
                    lines++;
                }
            }
        }
        return lines;
    }

    public int howManyXOColumns (String[][] array, String symbol){
        int columns = 0;
        int inColumns;

        for (int i = 0; i < 3; i++){
            inColumns = 0;
            for (int j = 0; j <3; j++){
                if (symbol.equals(array[j][i])){
                    inColumns++;
                }
                if (inColumns == 3){
                    columns++;
                }
            }
        }
        return columns;
    }
}
