package tictactoe;

import java.util.Scanner;

public class PlayerVsEasyGame {

    char [][] fieldArray;

    public void play(char player1, char player2){

        Scanner scanner = new Scanner(System.in);
        inputToArray toArray = new inputToArray();
        PrintField printField = new PrintField();
        CheckState printGameState = new CheckState();
        InsertMoveToFieldArray getArrayAfterMove = new InsertMoveToFieldArray();
        CheckMove checkInputCorrectness = new CheckMove();
        EasyLevelMoveGenerator easyGenerator = new EasyLevelMoveGenerator();

        if (player1 == 'u' && player2 == 'e'){

            String input = "         ";

            fieldArray = toArray.parseInputToArrays(input);

            printField.printField(fieldArray);

            while (!printGameState.isGameFinished) {
                do {
                    System.out.print("Enter the coordinates: ");
                    input = scanner.nextLine();
                    checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                } while (!checkInputCorrectness.possibleToContinue);

                printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player1"));

                printGameState.figureOutState(fieldArray);

                if (printGameState.figureOutState(fieldArray) == 'p') {
                    do {
                        checkInputCorrectness.checkInput(fieldArray, easyGenerator.generateCoordinates());
                    } while (!checkInputCorrectness.possibleToContinue && !printGameState.isGameFinished);

                    easyGenerator.printMessage();

                    printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, easyGenerator.coordinates, "player2"));
                }
                printGameState.figureOutState(fieldArray);
                printGameState.printGameState(printGameState.figureOutState(fieldArray));
            }
        } else if (player1 == 'u' && player2 == 'u'){
            String input = "         ";

            fieldArray = toArray.parseInputToArrays(input);

            printField.printField(fieldArray);

            while (!printGameState.isGameFinished) {
                do {
                    System.out.print("Enter the coordinates: ");
                    input = scanner.nextLine();
                    checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                } while (!checkInputCorrectness.possibleToContinue);

                printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player1"));

                do {
                    System.out.print("Enter the coordinates: ");
                    input = scanner.nextLine();
                    checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                } while (!checkInputCorrectness.possibleToContinue);

                printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player2"));
                printGameState.figureOutState(fieldArray);
                printGameState.printGameState(printGameState.figureOutState(fieldArray));
            }
        } else if (player1 == 'e' && player2 == 'u'){
            String input = "         ";

            fieldArray = toArray.parseInputToArrays(input);

            printField.printField(fieldArray);

            while (!printGameState.isGameFinished) {
                if (printGameState.figureOutState(fieldArray) == 'p') {
                    do {
                        checkInputCorrectness.checkInput(fieldArray, easyGenerator.generateCoordinates());
                    } while (!checkInputCorrectness.possibleToContinue && !printGameState.isGameFinished);

                    easyGenerator.printMessage();

                    printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, easyGenerator.coordinates, "player1"));
                }

                do {
                    System.out.print("Enter the coordinates: ");
                    input = scanner.nextLine();
                    checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                } while (!checkInputCorrectness.possibleToContinue);

                printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player2"));
                printGameState.figureOutState(fieldArray);
                printGameState.printGameState(printGameState.figureOutState(fieldArray));
            }
        } else if (player1 == 'e' && player2 == 'e'){
            String input = "         ";

            fieldArray = toArray.parseInputToArrays(input);

            printField.printField(fieldArray);

            while (!printGameState.isGameFinished) {
                if (printGameState.figureOutState(fieldArray) == 'p') {
                    do {
                        checkInputCorrectness.checkInput(fieldArray, easyGenerator.generateCoordinates());
                    } while (!checkInputCorrectness.possibleToContinue && !printGameState.isGameFinished);

                    easyGenerator.printMessage();

                    printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, easyGenerator.coordinates, "player1"));
                }
                if (printGameState.figureOutState(fieldArray) == 'p') {
                    do {
                        checkInputCorrectness.checkInput(fieldArray, easyGenerator.generateCoordinates());
                    } while (!checkInputCorrectness.possibleToContinue && !printGameState.isGameFinished);

                    easyGenerator.printMessage();

                    printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, easyGenerator.coordinates, "player2"));
                }
                printGameState.printGameState(printGameState.figureOutState(fieldArray));
            }
        }
    }
}
