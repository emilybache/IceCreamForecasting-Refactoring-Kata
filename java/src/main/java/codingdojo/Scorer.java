package codingdojo;

import java.time.Instant;
import java.util.Map;
import java.util.Random;

public class Scorer {

    public static IceCream flavour = null;

    public int getScore() {
        boolean sunnyToday = lookupWeather();
        return getScoreWithWeather(sunnyToday, flavour);
    }

    static int getScoreWithWeather(boolean sunnyToday, IceCream currentFlavour) {
        if (currentFlavour == null) {
            return -1;
        } else {
            switch (currentFlavour)
            {
                case Strawberry:
                    if (sunnyToday)
                        return 10;
                    else
                        return 5;
                case Chocolate:
                    return 6;
                case Vanilla:
                    if (sunnyToday)
                        return 7;
                    else
                        return 5;
                default:
                    return -1;
            }
        }
    }

    public boolean lookupWeather() {
        // placeholder implementation - real version would make API call to weather service
        return new Random().nextBoolean();
    }

    public boolean lookupWeather(Instant when) {
        // placeholder implementation - real version would make API call to weather service
        return new Random().nextBoolean();
    }

    public void updateSelection() {
        // placeholder implementation - real version would use machine learning to predict sales
        var score = getScore();
        if (score > 5) {
            var randomizer = new Random();
            IceCream[] allFlavours = IceCream.values();
            flavour = allFlavours[randomizer.nextInt(allFlavours.length)];
        }
    }

    public int getSalesForecast() {
        var forecasts = Map.of(
                IceCream.Strawberry, 9,
                IceCream.Vanilla, 11,
                IceCream.Chocolate, 3
        );
        return forecasts.get(flavour);
    }
}