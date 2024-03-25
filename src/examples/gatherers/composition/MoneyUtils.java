package examples.gatherers.composition;

import examples.gatherers.custom.Money;

import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

public class MoneyUtils {

    public static Gatherer<Money, ?, Money> computeBalanceHistory(Money balance){
        return Gatherers.scan(() -> balance, Money::add);
    }
}
