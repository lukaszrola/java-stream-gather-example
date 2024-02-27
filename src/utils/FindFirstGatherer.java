package utils;

import java.util.function.Predicate;
import java.util.stream.Gatherer;

public class FindFirstGatherer<T> implements Gatherer<T, T, T> {
    private final Predicate<T> predicate;

    public FindFirstGatherer(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Integrator<T, T, T> integrator() {
        return Integrator.ofGreedy((_, item, downstream) -> {
            if (predicate.test(item)) {
                downstream.push(item);
                return false;
            } else {
                return true;
            }
        });
    }
}
