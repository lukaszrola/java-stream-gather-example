package examples.gatherers.composition.game;

import java.util.Random;

public enum GameResult {
    PLAYER1_WON, PLAYER2_WON, DRAW;

    private static final Random RANDOM = new Random();
    public static GameResult randomResult() {
        return switch (RANDOM.nextInt(3)) {
            case 0 -> PLAYER1_WON;
            case 1 -> PLAYER2_WON;
            default -> DRAW;
        };
    }
}
