package org.codingdojo

import org.approvaltests.Approvals
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class DailyForecastsTest {

    val capturedOutput = ByteArrayOutputStream()
    var originalOutput: PrintStream? = null

    @BeforeEach
    fun captureStandardOutput() {
        originalOutput = System.out
        System.setOut(PrintStream(capturedOutput))
    }

    @AfterEach
    fun resetStandardOutput() {
        System.setOut(originalOutput)
    }

    @Test
    fun salesForecast() {
        val forecasts = DailyForecasts()
        forecasts.printSalesForecasts()
        Approvals.verify(capturedOutput)
    }
}
