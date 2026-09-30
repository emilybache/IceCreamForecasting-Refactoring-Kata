using Xunit;
using IceCreamScorer;
using System;
using System.IO;

namespace IceCreamScorer.Tests
{
    public class DailyForecastsTest
    {
        private readonly StringWriter capturedOutput = new StringWriter();
        private TextWriter originalOutput;

        public DailyForecastsTest()
        {
            originalOutput = Console.Out;
            Console.SetOut(capturedOutput);
        }

        public void Dispose()
        {
            Console.SetOut(originalOutput);
        }

        [Fact]
        public void SalesForecast()
        {
            var forecasts = new DailyForecasts();
            forecasts.PrintSalesForecasts();

            var approved = File.ReadAllText(Path.Combine(AppContext.BaseDirectory, "DailyForecastsTest.salesForecast.approved.txt"));
            Assert.Equal(approved, capturedOutput.ToString());
            Dispose();
        }
    }
}
