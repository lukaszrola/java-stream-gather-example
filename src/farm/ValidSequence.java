import farm.Animal;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherers;

import static farm.Animal.*;

public static void main() {
    var validSequence = List.of(SHEEP, SHEPARD, WOLF, WOLF);
    var invalidSequence = List.of(SHEPARD, SHEEP, WOLF, WOLF);

    Predicate<List<Animal>> validTriplePredicate = triple -> !(triple.contains(SHEEP) && triple.contains(WOLF) && !triple.contains(SHEPARD));

    var tripleWindowGatherer = Gatherers.<Animal>windowSliding(3);
    var isValidTripleGatherer = Gatherers.<List<Animal>, Boolean>fold(() -> true, (result, triple) -> result && validTriplePredicate.test(triple));
    var isValidSequenceGatherer = tripleWindowGatherer.andThen(isValidTripleGatherer);

    var resultForValidSequence = validSequence.stream().gather(isValidSequenceGatherer);
    var resultForInvalidSequence = invalidSequence.stream().gather(isValidSequenceGatherer);

    resultForValidSequence.forEach(System.out::println); // true
    resultForInvalidSequence.forEach(System.out::println); // false
}

