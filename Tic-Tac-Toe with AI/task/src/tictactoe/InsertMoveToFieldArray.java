package tictactoe;

public class InsertMoveToFieldArray {

    public char[][] addSymbolToArray(char[][] array, String coordinates, String actor){
        char[] tempArray = coordinates.replaceAll(" ", "").toCharArray();
        int [] tempArrayInt = new int[tempArray.length];
        for (int i = 0; i < tempArrayInt.length; i++) {
            tempArrayInt[i] = tempArray[i] - '0';
        }
        if ("user".equals(actor)){
            array[0 - (tempArrayInt[1]-3)] [(tempArrayInt[0] - 1)] = 'X';
        }else if ("robot".equals(actor)){
            array[0 - (tempArrayInt[1]-3)] [(tempArrayInt[0] - 1)] = 'O';
        }
        return array;
    }
}
