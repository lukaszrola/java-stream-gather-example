
import money.Money;
import money.ReduceByCurrency;

import java.math.BigDecimal;
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


    money.stream().gather(new ReduceByCurrency()).forEach(System.out::println);
}
