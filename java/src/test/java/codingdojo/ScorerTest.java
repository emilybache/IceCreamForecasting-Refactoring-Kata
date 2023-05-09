package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScorerTest {
    @Test
    void getScore() {
        var scorer = new Scorer();
        assertEquals(-1, scorer.getScore());
    }

}
