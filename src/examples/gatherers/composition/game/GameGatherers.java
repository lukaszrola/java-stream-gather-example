package examples.gatherers.composition.game;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

public class GameGatherers {

    public static Gatherer<Player, ?, Game> performGamesGatherer() {
        Gatherer<Player,?, List<Player>> pairPlayersGatherer = Gatherers.windowFixed(2);
        Gatherer<List<Player>,?, Game> simulateGamesGatherer = Gatherers.mapConcurrent(4, players -> {
            if(players.size() != 2) {
                return Game.INVALID_GAME;
            }
            return Game.completedGame(players.get(0), players.get(1), GameResult.randomResult());
        });

        return pairPlayersGatherer.andThen(simulateGamesGatherer);
    }
}