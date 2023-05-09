package codingdojo;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRangeForecastsTest {

    @Test
    void longRangeForecast() {
        var quarter = "Q3";
        var actual = new LongRangeForecasts().longRangeForecast(quarter);
        StringBuilder printedResult = printIceCreamForecast(actual);

        Approvals.verify(printedResult);
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
