package codingdojo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DailyForecasts {
    private final Scorer scorer = new Scorer();



    public void printSalesForecasts() {
        var names = List.of( "Steve", "Julie", "Francis");
        var formatter = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.from(ZoneOffset.UTC));
        System.out.println("Forecast at: " + formatter.format(Instant.now()));

        for (String name: names) {
            if (Objects.equals(name, "Steve"))
            {
                Scorer.flavour = IceCream.Strawberry;
            }
            else
            {
                scorer.updateSelection();
            }
            int score = scorer.getSalesForecast();
            System.out.println(name + " score: " + score);
        }
    }


}
