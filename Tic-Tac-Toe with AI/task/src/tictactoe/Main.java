package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TextMessages textMessages = new TextMessages();
        CommandProcessor commandProcessor = new CommandProcessor();
        inputToArray toArray = new inputToArray();
        PrintField printField = new PrintField();
        CheckState printGameState = new CheckState();
        InsertMoveToFieldArray getArrayAfterMove = new InsertMoveToFieldArray();
        CheckMove checkInputCorrectness = new CheckMove();
        EasyLevelMoveGenerator easyGenerator = new EasyLevelMoveGenerator();

        char [][] fieldArray;

        String input;
        while (!commandProcessor.endGame) {
            System.out.print(textMessages.askForCommand);
            input = scanner.nextLine();
            commandProcessor.checkCorrectness(commandProcessor.inputToArray(input));
            if (commandProcessor.correctCommand && !commandProcessor.endGame) {
                commandProcessor.definePlayers(commandProcessor.inputToArray(input));

                if (commandProcessor.player1 == 'u' && commandProcessor.player2 == 'e'){

                    input = "         ";

                    fieldArray = toArray.parseInputToArrays(input);

                    printField.printField(fieldArray);

                    while (!printGameState.isGameFinished) {
                        if (printGameState.figureOutState(fieldArray) == 'p') {
                            do {
                                System.out.print("Enter the coordinates: ");
                                input = scanner.nextLine();
                                checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                            } while (!checkInputCorrectness.possibleToContinue);

                            printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player1"));
                        }

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
                } else if (commandProcessor.player1 == 'u' && commandProcessor.player2 == 'u'){
                    input = "         ";

                    fieldArray = toArray.parseInputToArrays(input);

                    printField.printField(fieldArray);

                    while (!printGameState.isGameFinished) {

                        if (printGameState.figureOutState(fieldArray) == 'p') {
                            do {
                                System.out.print("Enter the coordinates: ");
                                input = scanner.nextLine();
                                checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                            } while (!checkInputCorrectness.possibleToContinue);

                            printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player1"));
                        }

                        if (printGameState.figureOutState(fieldArray) == 'p') {
                            do {
                                System.out.print("Enter the coordinates: ");
                                input = scanner.nextLine();
                                checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                            } while (!checkInputCorrectness.possibleToContinue);

                            printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player2"));
                        }
                        printGameState.figureOutState(fieldArray);
                        printGameState.printGameState(printGameState.figureOutState(fieldArray));
                    }
                } else if (commandProcessor.player1 == 'e' && commandProcessor.player2 == 'u'){
                    input = "         ";

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
                                System.out.print("Enter the coordinates: ");
                                input = scanner.nextLine();
                                checkInputCorrectness.printMessage(checkInputCorrectness.checkInput(fieldArray, input));
                            } while (!checkInputCorrectness.possibleToContinue);

                            printField.printField(getArrayAfterMove.addSymbolToArray(fieldArray, input, "player2"));
                        }
                        printGameState.figureOutState(fieldArray);
                        printGameState.printGameState(printGameState.figureOutState(fieldArray));
                    }
                } else if (commandProcessor.player1== 'e' && commandProcessor.player2 == 'e'){
                    input = "         ";

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
            }else if (commandProcessor.endGame){
                break;
            }else {
                System.out.println(textMessages.badParams);
            }
        }
    }
}