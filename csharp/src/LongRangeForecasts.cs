using System;
using System.Collections.Generic;
using System.Linq;

namespace IceCreamScorer
{
    public class LongRangeForecasts
    {
        private readonly Scorer scorer;

        public LongRangeForecasts(Scorer scorer)
        {
            this.scorer = scorer;
        }
        public Dictionary<IceCream, int> LongRangeForecast(string quarter) {
                
            var result = new Dictionary<IceCream, int>();
            if (quarter == "Q1" || quarter == "Q4") {
                foreach (IceCream flavour in Enum.GetValues(typeof(IceCream))) {
                    result[flavour] = 5;
                }
            }
            foreach (IceCream flavour in Enum.GetValues(typeof(IceCream))) {
                result[flavour] = 0;
            }
            List<DateTime> interestingDates = new List<DateTime>() {
                DateTime.Parse("2023-05-01T14:00:00.000-07:00"),
                DateTime.Parse("2023-05-18T14:00:00.000-07:00"),
                DateTime.Parse("2023-06-05T14:00:00.000-07:00"),
                DateTime.Parse("2023-06-23T14:00:00.000-07:00")
            };
            List<bool> expectedWeather = new List<bool>();
            foreach (DateTime day in interestingDates) {

                scorer.UpdateSelection();
                var daysForward = (day - DateTime.Parse("2023-04-26T14:00:00.000-07:00")).Days;
                bool weather = scorer.LookupWeather(daysForward:daysForward);
                expectedWeather.Add(weather);
            }

            foreach (IceCream flavour in result.Keys) {
                result[flavour] += 10;
                var sunnyHolidays = expectedWeather.Select(x => x).Count();
                if (sunnyHolidays > 2 && flavour == IceCream.Vanilla) {
                    result[flavour] +=  5;
                }
                else if (sunnyHolidays > 1 && expectedWeather[0]) {
                    result[flavour] += 2;
                }
            }
            return result;
        }
    }
}