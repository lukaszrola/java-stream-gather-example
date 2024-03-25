package examples.gatherers.custom.gatherers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

class ReduceByGatherer<T, P> implements Gatherer<T, Map<P, T>, T> {
    private final Function<T, P> selector;
    private final BiFunction<T, T, T> operation;

    ReduceByGatherer(Function<T, P> extractor, BiFunction<T, T, T> reducer) {
        this.selector = extractor;
        this.operation = reducer;
    }

    @Override
    public Supplier<Map<P, T>> initializer() {
        return HashMap::new;
    }

    @Override
    public Integrator<Map<P, T>, T, T> integrator() {
        return Integrator.ofGreedy((state, item, _) -> {
            state.merge(selector.apply(item), item, operation);
            return true;
        });
    }

    @Override
    public BiConsumer<Map<P, T>, Downstream<? super T>> finisher() {
        return (state, downstream) -> state.values().forEach(downstream::push);
    }
}
