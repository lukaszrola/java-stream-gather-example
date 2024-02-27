package money.gatherers;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Gatherer;

public class MyGatherers {
    public static <T, P> Gatherer<T, Set<P>, T> distinctBy(Function<T, P> extractor) {
        return new DistinctByGatherer<>(extractor);
    }

    public static <T, P> Gatherer<T, Map<P, T>, T> reduceBy(Function<T, P> extractor, BiFunction<T, T, T> reducer) {
        return new ReduceByGatherer<>(extractor, reducer);
    }

    public static <T, B extends Comparable<B>> Gatherer<T, ?, T> maxBy(Function<T, B> extractor) {
        return new MaxByGatherer<>(extractor);
    }

    public static <T, M> Gatherer<T, T, M> mapNotNull(Function<T, M> mapper) {
        return new MapNotNullGatherer<>(mapper);
    }

    public static <T> Gatherer<T, T, T> findFirst(Predicate<T> predicate) {
        return new FindFirstGatherer<>(predicate);
    }
}
