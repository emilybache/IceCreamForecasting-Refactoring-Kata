package codingdojo;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.core.Options;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {


    @Test
    void getScore() {

        var weathers = new Boolean[]{true, false};
        var flavours = new IceCream[]{IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla, null};

        CombinationApprovals.verifyAllCombinations(
                Scorer::getScoreWithWeather,
                weathers,
                flavours
        );
    }

}
