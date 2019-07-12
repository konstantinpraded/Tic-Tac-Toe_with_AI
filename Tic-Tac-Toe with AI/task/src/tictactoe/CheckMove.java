package tictactoe;

public class CheckMove {

    public String checkInput (String coordinates){
        String tempInput = coordinates.replaceAll(" ", "");

        /*if (tempInput.length() > 2 || tempInput <2){
            System.out.println("Incorrect coordinates");
        }*/
        char firstCoordinate = tempInput.charAt(0);
        char secondCoordinate = tempInput.charAt(1);



        char[] tempArray = coordinates.replaceAll(" ", "").toCharArray();
        int [] tempArrayInt = new int[tempArray.length];
        for (int i = 0; i < tempArrayInt.length; i++) {
            tempArrayInt[i] = tempArray[i] - '0';
        }

        return coordinates;

    }
}
