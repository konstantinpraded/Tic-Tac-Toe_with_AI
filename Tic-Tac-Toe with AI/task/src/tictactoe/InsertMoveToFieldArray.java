package tictactoe;

public class InsertMoveToFieldArray {

    public char[][] addSymbolToArray(char[][] array, String coordinates){
        char[] tempArray = coordinates.replaceAll(" ", "").toCharArray();
        int [] tempArrayInt = new int[tempArray.length];
        for (int i = 0; i < tempArrayInt.length; i++) {
            tempArrayInt[i] = tempArray[i] - '0';
        }
        array[0 - (tempArrayInt[1]-3)] [(tempArrayInt[0] - 1)] = 'X';
        return array;
    }
}
