using System;
using System.Collections.Generic;
using System.Linq;

namespace IceCreamScorer
{
    public class LongRangeForecasts
    {
        private readonly Scorer scorer = new Scorer();

        public Dictionary<IceCream, int> LongRangeForecast(string quarter)
        {
            var result = new Dictionary<IceCream, int>();
            if (quarter == "Q1" || quarter == "Q4")
            {
                foreach (IceCream flavour in Enum.GetValues(typeof(IceCream)))
                {
                    result[flavour] = 5;
                }
            }
            foreach (IceCream flavour in Enum.GetValues(typeof(IceCream)))
            {
                result[flavour] = 0;
            }
            var interestingDates = new List<DateTimeOffset>
            {
                DateTimeOffset.Parse("2023-05-01T14:00:00.000-07:00"),
                DateTimeOffset.Parse("2023-05-18T14:00:00.000-07:00"),
                DateTimeOffset.Parse("2023-06-05T14:00:00.000-07:00"),
                DateTimeOffset.Parse("2023-06-23T14:00:00.000-07:00")
            };
            var expectedWeather = new List<bool>();
            foreach (var interestingDate in interestingDates)
            {
                scorer.UpdateSelection();
                var forecastDate = DateTimeOffset.Parse("2023-04-26T14:00:00.000-07:00");
                var daysForward = (interestingDate - forecastDate).Days;
                bool lookupWeather = scorer.LookupWeather(daysForward);
                expectedWeather.Add(lookupWeather);
            }

            foreach (var flavour in result.Keys)
            {
                result[flavour] = result[flavour] + 10;
                var sunnyHolidays = expectedWeather.Count(s => s);
                if (sunnyHolidays > 2 && flavour == IceCream.Vanilla)
                {
                    result[flavour] = result[flavour] + 5;
                }
                if (sunnyHolidays > 1 && expectedWeather[1])
                {
                    result[flavour] = result[flavour] + 2;
                }
            }
            return result;
        }
    }
}