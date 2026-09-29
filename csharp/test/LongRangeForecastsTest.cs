using Xunit;
using IceCreamScorer;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace IceCreamScorer.Tests
{
    public class LongRangeForecastsTest
    {
        [Fact]
        public void LongRangeForecast()
        {
            var quarter = "Q3";
            var actual = new LongRangeForecasts().LongRangeForecast(quarter);
            var printedResult = PrintIceCreamForecast(actual);

            var approved = File.ReadAllText(Path.Combine(AppContext.BaseDirectory, "LongRangeForecastsTest.longRangeForecast.approved.txt"));
            Assert.Equal(approved, printedResult.ToString());
        }

        private static StringBuilder PrintIceCreamForecast(Dictionary<IceCream, int> actual)
        {
            var printedResult = new StringBuilder();
            printedResult.Append("{");
            // Java sorts the keys by enum ordinal, which matches declaration order.
            foreach (IceCream key in Enum.GetValues<IceCream>())
            {
                printedResult.Append(key);
                printedResult.Append(":");
                printedResult.Append(actual[key]);
                printedResult.Append(", ");
            }
            printedResult.Append("}");
            return printedResult;
        }
    }
}
