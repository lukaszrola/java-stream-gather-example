import farm.AnimalStreamUtils;
import farm.StringStreamUtils;

import java.util.List;
import java.util.stream.Gatherers;

import static farm.Animal.*;

public void main() {
    var validSequence = List.of(SHEEP, SHEPARD, WOLF, WOLF);
    var invalidSequence = List.of(SHEPARD, SHEEP, WOLF, WOLF);

    System.out.println("Valid animal sequence:");
    validSequence.stream()
            .gather(AnimalStreamUtils.isValidSequence())
            .forEach(System.out::println);

    System.out.println("\nInvalid animal sequence:");
    invalidSequence.stream()
            .gather(AnimalStreamUtils.isValidSequence())
            .forEach(System.out::println);

    var listOfNames = List.of("John", "Marry", "George", "Ann", "Pete", "Stuart", "Adam");

    System.out.println("\nCombine into pairs:");
    listOfNames.stream()
            .gather(StringStreamUtils.combineIntoPairs())
            .forEach(System.out::println);
}

