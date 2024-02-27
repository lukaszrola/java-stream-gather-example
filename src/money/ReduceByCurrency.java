package money;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public record ReduceByCurrency() implements Gatherer<Money, Map<Currency, Money>, Money> {

    @Override
    public Supplier<Map<Currency, Money>> initializer() {
        return HashMap::new;
    }

    @Override
    public Integrator<Map<Currency, Money>, Money, Money> integrator() {
        return Integrator.ofGreedy((currencies, element, _) -> {
            currencies.merge(element.currency(), element, Money::add);
           return true;
        });
    }

    @Override
    public BiConsumer<Map<Currency, Money>, Downstream<? super Money>> finisher() {
        return (state, downstream) -> state.values().forEach(downstream::push);
    }

}
