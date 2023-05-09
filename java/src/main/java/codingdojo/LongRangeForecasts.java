package codingdojo;

import java.time.Instant;
import java.util.*;

public class LongRangeForecasts {

    private final Scorer scorer = new Scorer();

    public Map<IceCream, Integer> longRangeForecast(String quarter) {
        var result = new HashMap<IceCream, Integer>();
        if (Objects.equals(quarter, "Q1") || Objects.equals(quarter, "Q4")) {
            for (IceCream flavour : IceCream.values()) {
                result.put(flavour, 5);
            }
            return result;
        }
        for (IceCream flavour : IceCream.values()) {
            result.put(flavour, 0);
        }
        List<Instant> interestingDates = List.of(
                Instant.parse("2023-05-01T14:00:00.000-07:00"),
                Instant.parse("2023-05-18T14:00:00.000-07:00"),
                Instant.parse("2023-06-05T14:00:00.000-07:00"),
                Instant.parse("2023-06-23T14:00:00.000-07:00")
        );
        List<Boolean> expectedWeather = new ArrayList<>();
        for (Instant interestingDate : interestingDates) {
            Boolean lookupWeather = scorer.lookupWeather(interestingDate);
            expectedWeather.add(lookupWeather);
        }

        for (IceCream flavour : result.keySet()) {
            result.put(flavour, 10);
            var sunnyHolidays = expectedWeather.stream().filter(s -> s).count();
            if (sunnyHolidays > 2 && flavour == IceCream.Vanilla) {
                result.put(flavour, 15);
            }
            if (expectedWeather.get(1) && flavour == IceCream.Chocolate) {
                result.put(flavour, 12);
            }
        }
        return result;
    }
}
