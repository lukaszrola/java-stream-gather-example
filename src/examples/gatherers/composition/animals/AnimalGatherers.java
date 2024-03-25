package examples.gatherers.composition.animals;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

import static examples.gatherers.composition.animals.Animal.*;

public class AnimalGatherers {

    public static Gatherer<Animal, ?, Boolean> isValidSequence() {
        Predicate<List<Animal>> validTriplePredicate = triple -> !(
                triple.contains(SHEEP) && triple.contains(WOLF) && !triple.contains(SHEEP_DOG)
        );

        var tripleWindowGatherer = Gatherers.<Animal>windowSliding(3);
        var areAllTriplesValidGatherer = Gatherers.<List<Animal>, Boolean>fold(
                () -> true,
                (result, triple) -> result && validTriplePredicate.test(triple)
        );

        return tripleWindowGatherer.andThen(areAllTriplesValidGatherer);
    }
}
