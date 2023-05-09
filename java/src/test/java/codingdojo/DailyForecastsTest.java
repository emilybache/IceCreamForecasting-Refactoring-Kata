package codingdojo;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        forecasts.printSalesForecastsWithUpdateSelection(
                Instant.parse("2023-05-09T13:44:18.039431Z"),
                new Runnable() {
                    @Override
                    public void run() {
                        // do nothing
                    }
                }
        );
        Approvals.verify(capturedOutput);
    }
}
