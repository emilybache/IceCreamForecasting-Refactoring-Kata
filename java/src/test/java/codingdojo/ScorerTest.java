package codingdojo;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {
    @Test
    void getScore() {
        Boolean[] sunnyTodays = new Boolean[]{true, false};
        String[] flavours =  Arrays.stream(IceCream.values())
                .map(Enum::name)
                .toList()
                .toArray(new String[0]);

        CombinationApprovals.verifyAllCombinations(
                ScorerTest::doGetScore,
                sunnyTodays,
                flavours
                );
    }


    static String doGetScore(Boolean sunnyToday, String flavourName) {
        Scorer.flavour = IceCream.valueOf(flavourName);
        int actual = Scorer.getScoreWithWeather(sunnyToday);
        return "" + actual;
    }

}
