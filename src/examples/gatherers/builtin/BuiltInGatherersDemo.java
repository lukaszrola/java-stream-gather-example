package examples.gatherers.builtin;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class BuiltInGatherersDemo {
    public void main() {

        System.out.println("Fold example:");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.fold(() -> 1, (a, b) -> a * b))
                .forEach(System.out::println);

        System.out.println("Map concurrent example:");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.mapConcurrent(4, a -> a *2))
                .forEach(System.out::println);

        System.out.println("Scan example:");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.scan(()->1, (a,b) -> a*b))
                .forEach(System.out::println);

        System.out.println("Window fixed example:");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.windowFixed(2))
                .forEach(System.out::println);

        System.out.println("Window sliding example:");
        Stream.of(1, 2, 3, 4, 5)
                .gather(Gatherers.windowSliding(2))
                .forEach(System.out::println);
    }
}
