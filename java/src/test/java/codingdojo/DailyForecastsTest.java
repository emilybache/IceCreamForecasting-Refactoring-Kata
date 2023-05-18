package codingdojo;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.scrubbers.DateScrubber;
import org.approvaltests.scrubbers.RegExScrubber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DailyForecastsTest {

    final ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
    PrintStream originalOutput;

    @BeforeEach
    void captureStandardOutput() {
        originalOutput = System.out;
        System.setOut(new PrintStream(capturedOutput));
    }

    @AfterEach
    void resetStandardOutput() {
        System.setOut(originalOutput);
    }

    @Test
    void salesForecast() {
        var forecasts = new DailyForecasts();
        forecasts.printSalesForecasts(new Runnable() {
            @Override
            public void run() {
                // do nothing
            }
        });
        Approvals.verify(capturedOutput,new Options().withScrubber(
                new RegExScrubber("\\d\\d\\d\\d-\\d\\d-\\d\\d", "date")
                )
        );
    }
}
