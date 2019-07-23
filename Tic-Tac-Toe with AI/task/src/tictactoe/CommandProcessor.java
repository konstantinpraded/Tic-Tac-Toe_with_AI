package tictactoe;

import java.util.Arrays;

public class CommandProcessor {
    char player1;
    char player2;
    boolean correctCommand = false;
    boolean endGame = false;
    String[] inputArray;

    public void definePlayers(String[] inputArray){
        if ("easy".equals(inputArray[1])){
            player1 = 'e';
        }else if ("user".equals(inputArray[1])){
            player1 = 'u';
        }
        if ("easy".equals(inputArray[2])){
            player2 = 'e';
        }else if ("user".equals(inputArray[2])){
            player2 = 'u';
        }
    }


    public boolean checkCorrectness(String[] inputArray) {
        if (inputArray.length == 3) {
            if ("start".equals(inputArray[0])) {
                if (("easy".equals(inputArray[1]) || "user".equals(inputArray[1])) && ("easy".equals(inputArray[2]) || "user".equals(inputArray[2]))) {
                    correctCommand = true;
                } else {
                    correctCommand = false;
                }
            } else {
                correctCommand = false;
            }
        } else if (inputArray.length == 1 && "exit".equals(inputArray[0])) {
            correctCommand = true;
            endGame = true;
        } else {
            correctCommand = false;
        }
        return correctCommand;
    }


    public String[] inputToArray(String input) {

        inputArray = input.split(" ");
        return inputArray;
    }
}
