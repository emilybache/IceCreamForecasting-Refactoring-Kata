package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongRangeForecastsTest {

    @Test
    void longRangeForecast() {
        var expected = Map.of(
                IceCream.Strawberry, 0,
                IceCream.Vanilla, 0,
                IceCream.Chocolate, 0
        );
        var actual = new LongRangeForecasts().longRangeForecast("Q3");
        assertEquals(expected, actual);
    }
}
