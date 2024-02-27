package farm;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Gatherers;

public class StringStreamUtils {

    public static Gatherer<String, ?, String> combineIntoPairs() {

        Gatherer<String, ?, List<String>> splitToPairsGatherer = Gatherers.windowFixed(2);
        Gatherer<List<String>, ?, String> combinePairGatherer = Gatherers.mapConcurrent(4, names -> String.join(" and ", names));

        return splitToPairsGatherer.andThen(combinePairGatherer);
    }
}
