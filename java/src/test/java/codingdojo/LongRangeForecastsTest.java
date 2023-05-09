package codingdojo;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRangeForecastsTest {

    String calculateLongRangeForecast(String quarter,
                                                     Boolean weather1,
                                                     Boolean weather2,
                                                     Boolean weather3,
                                                     Boolean weather4) {
        var weatherMap = Map.of(
                Instant.parse("2023-05-01T14:00:00.000-07:00"), weather1,
                Instant.parse("2023-05-18T14:00:00.000-07:00"), weather2,
                Instant.parse("2023-06-05T14:00:00.000-07:00"), weather3,
                Instant.parse("2023-06-23T14:00:00.000-07:00"), weather4
        );

        var weather = new Boolean[] {true, true, false, false};
        Function<Instant, Boolean> goodWeather = interestingDate1 -> {
            return weatherMap.getOrDefault(interestingDate1, true);
        };

        var actual = LongRangeForecasts.longRangeForecastWithScorerLookup(quarter, goodWeather);
        StringBuilder printedResult = printIceCreamForecast(actual);
        return printedResult.toString();
    }

    @Test
    void longRangeForecast() {
        var quarters = new String[]{"Q1", "Q2", "Q3", "Q4"};
        var weather1s = new Boolean[]{true, false};
        var weather2s = new Boolean[]{true, false};
        var weather3s = new Boolean[]{true, false};
        var weather4s = new Boolean[]{true, false};


        CombinationApprovals.verifyBestCoveringPairs(
                this::calculateLongRangeForecast,
                quarters,
                weather1s,
                weather2s,
                weather3s,
                weather4s
        );
    }

    private static StringBuilder printIceCreamForecast(Map<IceCream, Integer> actual) {
        var printedResult = new StringBuilder();
        printedResult.append("{");
        var sortedKeys = new ArrayList<IceCream>(actual.keySet());
        Collections.sort(sortedKeys);
        for (IceCream key : sortedKeys) {
            printedResult.append(key);
            printedResult.append(":");
            printedResult.append(actual.get(key));
            printedResult.append(", ");
        }
        printedResult.append("}");
        return printedResult;
    }
}
