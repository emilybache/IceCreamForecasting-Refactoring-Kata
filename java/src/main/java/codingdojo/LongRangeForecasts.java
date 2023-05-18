package codingdojo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LongRangeForecasts {

    private final Scorer scorer = new Scorer();

    public Map<IceCream, Integer> longRangeForecast(String quarter) {

        var result = new HashMap<IceCream, Integer>();
        if (Objects.equals(quarter, "Q1") || Objects.equals(quarter, "Q4")) {
            for (IceCream flavour : IceCream.values()) {
                result.put(flavour, 5);
            }
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
            scorer.updateSelection();
            var forecastDate = Instant.parse("2023-04-26T14:00:00.000-07:00");
            long daysForward = ChronoUnit.DAYS.between(forecastDate, interestingDate);
            Boolean lookupWeather = scorer.lookupWeather(daysForward);
            expectedWeather.add(lookupWeather);
        }

        for (IceCream flavour : result.keySet()) {
            result.put(flavour, result.get(flavour) + 10);
            var sunnyHolidays = expectedWeather.stream().filter(s -> s).count();
            if (sunnyHolidays > 2 && flavour == IceCream.Vanilla) {
                result.put(flavour, result.get(flavour) + 5);
            }
            if (sunnyHolidays > 1 && expectedWeather.get(1)) {
                result.put(flavour, result.get(flavour) + 2);
            }
        }
        return result;
    }
}
