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

        System.out.print("Enter cells: ");

        String input = scanner.nextLine();

        char [][] fieldArray = toArray.parseInputToArrays(input);

        printField.printField(fieldArray);
        //printGameState.figureOutAndPrintState(fieldArray);

        System.out.print("Enter the coordinates: ");

        input = scanner.nextLine();

        printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input));
    }
}
