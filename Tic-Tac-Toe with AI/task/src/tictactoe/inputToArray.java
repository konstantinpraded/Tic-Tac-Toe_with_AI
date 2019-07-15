package tictactoe;

public class inputToArray {
    char[][] contentArray;

    public char[][] parseInputToArrays (String input){
        input = input.replaceAll("\"", "");
        char [] tempArray = input. toCharArray();

        contentArray = new char[3][3];
        int lineCounter = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                contentArray[i][j] = tempArray[lineCounter];
                lineCounter++;
            }
        }
        return contentArray;
    }
}

