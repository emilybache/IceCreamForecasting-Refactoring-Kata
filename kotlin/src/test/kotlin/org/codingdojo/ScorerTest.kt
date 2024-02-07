package org.codingdojo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScorerTest {
    @Test
    fun getScore() {
        val scorer = Scorer()
        assertEquals(-1, scorer.getScore())
    }
}
