package examples.gatherers.composition.game;

public interface Game {
    Game INVALID_GAME = new InvalidGame();
    static Game completedGame(Player player1, Player player2, GameResult result) {
        return new CompletedGame(player1, player2, result);
    }
}

record CompletedGame(Player player1, Player player2, GameResult result) implements Game {
}

class InvalidGame implements Game {
    @Override
    public String toString() {
        return "INVALID GAME";
    }
}
