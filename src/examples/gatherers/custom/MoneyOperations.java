

import examples.gatherers.custom.Money;
import examples.gatherers.custom.gatherers.MyGatherers;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

private static final Currency EUR = Currency.getInstance("EUR");
private static final Currency PLN = Currency.getInstance("PLN");

public void main() {

    var money = List.of(
            new Money(BigDecimal.valueOf(12), PLN),
            new Money(BigDecimal.valueOf(11), EUR),
            new Money(BigDecimal.valueOf(15), PLN)
    );

    System.out.println("Distinct By Currency:");
    money.stream()
            .gather(MyGatherers.distinctBy(Money::currency))
            .forEach(System.out::println);

    System.out.println("\nReduce By Currency");
    money.stream()
            .gather(MyGatherers.reduceBy(Money::currency, Money::add))
            .forEach(System.out::println);

    System.out.println("\nFind first Gatherer");
    money.stream()
            .gather(MyGatherers.findFirst(m -> m.currency().equals(PLN)))
            .forEach(System.out::println);

    System.out.println("\nMax By Amount");
    money.stream()
            .parallel()
            .gather(MyGatherers.maxBy(Money::amount))
            .forEach(System.out::println);

    var moneyWithNulls = Arrays.asList(
            new Money(BigDecimal.valueOf(12), PLN),
            null,
            new Money(BigDecimal.valueOf(11), EUR),
            new Money(BigDecimal.valueOf(15), PLN),
            null
    );

    System.out.println("\nMap not-null Gatherer");
    moneyWithNulls.stream()
            .gather(MyGatherers.mapNotNull(m -> m.multiply(BigDecimal.TWO)))
            .forEach(System.out::println);
}