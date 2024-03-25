import examples.gatherers.composition.animals.AnimalGatherers;
import examples.gatherers.composition.MoneyUtils;
import examples.gatherers.composition.game.GameGatherers;
import examples.gatherers.composition.game.Player;
import examples.gatherers.custom.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import static examples.gatherers.composition.animals.Animal.*;

public static final Currency PLN = Currency.getInstance("PLN");

public void main() {
    var validSequence = List.of(SHEEP, SHEEP_DOG, WOLF, WOLF);
    System.out.println("Valid animal sequence result:");
    validSequence.stream()
            .gather(AnimalGatherers.isValidSequence())
            .forEach(System.out::println);

    var invalidSequence = List.of(SHEEP_DOG, SHEEP, WOLF, WOLF);
    System.out.println("\nInvalid animal sequence result:");
    invalidSequence.stream()
            .gather(AnimalGatherers.isValidSequence())
            .forEach(System.out::println);


    var listOfPlayers = List.of(
            new Player("John"),
            new Player("Marry"),
            new Player("George"),
            new Player("Ann"),
            new Player("Pete"),
            new Player("Stuart"),
            new Player("Adam")
    );

    System.out.println("\nGames result:");
    listOfPlayers.stream()
            .gather(GameGatherers.performGamesGatherer())
            .forEach(System.out::println);


    var transactions = List.of(
            new Money(BigDecimal.valueOf(-10), PLN),
            new Money(BigDecimal.valueOf(20), PLN),
            new Money(BigDecimal.valueOf(50), PLN)
    );

    var balance = new Money(BigDecimal.valueOf(270), PLN);

    System.out.println("\n Balance history:");
    transactions.stream()
            .gather(MoneyUtils.computeBalanceHistory(balance))
            .forEach(System.out::println);
}