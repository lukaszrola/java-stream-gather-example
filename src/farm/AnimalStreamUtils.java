package farm;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

import static farm.Animal.*;

public class AnimalStreamUtils {

    public static Gatherer<Animal, ?, Boolean> isValidSequence() {
        Predicate<List<Animal>> validTriplePredicate = triple -> !(triple.contains(SHEEP) && triple.contains(WOLF) && !triple.contains(SHEPARD));

        var tripleWindowGatherer = Gatherers.<Animal>windowSliding(3);
        var isValidTripleGatherer = Gatherers.<List<Animal>, Boolean>fold(() -> true, (result, triple) -> result && validTriplePredicate.test(triple));

        return tripleWindowGatherer.andThen(isValidTripleGatherer);
    }
}
