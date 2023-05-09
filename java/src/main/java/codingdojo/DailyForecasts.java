package codingdojo;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class DailyForecasts {
    private final Scorer scorer = new Scorer();

    public void printSalesForecasts() {
        Instant now = Instant.now();
        Runnable updateSelection = () -> scorer.updateSelection();

        printSalesForecastsWithUpdateSelection(now, updateSelection);
    }

    void printSalesForecastsWithUpdateSelection(Instant now, Runnable updateSelection) {
        var names = List.of("Steve", "Julie", "Francis");
        System.out.println("Forecast at: " + now);

        for (String name : names) {
            if (Objects.equals(name, "Steve")) {
                Scorer.flavour = IceCream.Strawberry;
            } else {
                updateSelection.run();
            }
            int score = scorer.getSalesForecast();
            System.out.println(name + " score: " + score);
        }
    }


}
