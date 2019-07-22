package tictactoe;

import java.util.Random;

public class EasyLevelMoveGenerator {

    int randomVertically = 0;
    int randomHorizontally = 0;
    String coordinates = "";

    public String generateCoordinates() {
        Random random = new Random();
        randomVertically = random.nextInt(4 - 1) + 1;
        randomHorizontally = random.nextInt(4 - 1) + 1;
        coordinates = Integer.toString(randomVertically) + Integer.toString(randomHorizontally);
        return coordinates;
    }

    public void printMessage(){
        System.out.println("Making move level \"easy\"");
    }
}
