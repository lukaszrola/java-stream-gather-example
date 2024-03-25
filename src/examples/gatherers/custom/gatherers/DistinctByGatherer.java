package examples.gatherers.custom.gatherers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

class DistinctByGatherer<T, P> implements Gatherer<T, Set<P>, T> {

    private final Function<T, P> extractor;

    DistinctByGatherer(Function<T, P> extractor) {
        this.extractor = extractor;
    }

    @Override
    public Supplier<Set<P>> initializer() {
        return HashSet::new;
    }

    @Override
    public Integrator<Set<P>, T, T> integrator() {
        return Integrator.ofGreedy((state, item, downstream) -> {
            P extracted = extractor.apply(item);
            if(!state.contains(extracted)) {
                state.add(extracted);
                downstream.push(item);
            }

            return true;
        });
    }
}
