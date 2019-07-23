package tictactoe;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        inputToArray toArray = new inputToArray();
        PrintField printField = new PrintField();
        CheckState printGameState = new CheckState();
        InsertMoveToFieldArray getArrayAfterMove = new InsertMoveToFieldArray();
        CheckMove checkInputCorrectness = new CheckMove();
        EasyLevelMoveGenerator easyGenerator = new EasyLevelMoveGenerator();

        //System.out.print("Enter cells: ");

        String input = "         ";

        char [][] fieldArray = toArray.parseInputToArrays(input);

        printField.printField(fieldArray);

        while (!printGameState.isGameFinished) {
            do {
                System.out.print("Enter the coordinates: ");
                input = scanner.nextLine();
                checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
            } while (!checkInputCorrectness.possibleToContinue);

            printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "user"));

            printGameState.figureOutState(fieldArray);

            if (printGameState.figureOutState(fieldArray) == 'p') {
                do {
                    checkInputCorrectness.checkInput(fieldArray, easyGenerator.generateCoordinates());
                } while (!checkInputCorrectness.possibleToContinue && !printGameState.isGameFinished);

                easyGenerator.printMessage();

                printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, easyGenerator.coordinates, "robot"));
            }
            printGameState.figureOutState(fieldArray);
            printGameState.printGameState(printGameState.figureOutState(fieldArray));
        }
    }
}
