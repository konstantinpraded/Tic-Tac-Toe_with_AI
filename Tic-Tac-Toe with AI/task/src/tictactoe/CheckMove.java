package tictactoe;

public class CheckMove {

    boolean possibleToContinue = true;

    public char checkInput (char [][] array, String coordinates){
        String tempInput = coordinates.replaceAll(" ", "");

        char firstCoordinate = tempInput.charAt(0);
        char secondCoordinate = tempInput.charAt(1);

        char errorCode = 'z';

        boolean firstIsDigit = Character.isDigit(firstCoordinate);
        boolean secondIsDigit = Character.isDigit(secondCoordinate);

        if (Character.isDigit(firstCoordinate) && Character.isDigit(secondCoordinate)){

            int firstCoordinateInt = firstCoordinate - '0';
            int secondCoordinateInt = secondCoordinate - '0';

            if (firstCoordinateInt < 4 && firstCoordinateInt >0 && secondCoordinateInt <4 && secondCoordinateInt >0){
                if ('X'== array[0 - (secondCoordinateInt-3)][firstCoordinateInt - 1] || 'O'== array[0 - (secondCoordinateInt-3)][firstCoordinateInt - 1]){
                    errorCode = 'o';
                }
            }else {
                errorCode = 'c';
            }
        } else {
            errorCode = 'n';
        }

        return errorCode;

    }

    public void printMessage (char errorCode){
        possibleToContinue = true;
        switch (errorCode){
            case 'o':
                System.out.println("This cell is occupied! Choose another one!");
                possibleToContinue = false;
                break;
            case 'c':
                System.out.println("Coordinates should be from 1 to 3");
                possibleToContinue = false;
                break;
            case 'n':
                System.out.println("You should enter numbers!");
                possibleToContinue = false;
                break;
            default:
                break;
        }
    }
}
