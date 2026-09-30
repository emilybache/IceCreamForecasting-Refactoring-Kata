using System;
using System.Collections.Generic;

namespace IceCreamScorer
{
    public class Scorer
    {
        public static IceCream? Flavour;

        public int GetScore()
        {
            bool sunnyToday = LookupWeather();
            if (Flavour == null)
            {
                return -1;
            }
            else
            {
                switch (Flavour)
                {
                    case IceCream.Strawberry:
                        if (sunnyToday)
                            return 10;
                        else
                            return 5;
                    case IceCream.Chocolate:
                        return 6;
                    case IceCream.Vanilla:
                        if (sunnyToday)
                            return 7;
                        else
                            return 5;
                    default:
                        return -1;
                }
            }
        }

        public bool LookupWeather()
        {
            // placeholder implementation - real version would make API call to weather service
            return Random.Shared.Next(2) == 1;
        }

        public bool LookupWeather(long daysForward)
        {
            // placeholder implementation - real version would make API call to weather service
            return Random.Shared.Next(2) == 1;
        }

        public bool LookupWeather(KeyValuePair<double, double> location)
        {
            // placeholder implementation - real version would make API call to weather service
            return Random.Shared.Next(2) == 1;
        }

        public void UpdateSelection()
        {
            // placeholder implementation - real version would use machine learning to predict sales
            var score = GetScore();
            if (score > 5)
            {
                var allFlavours = (IceCream[])Enum.GetValues(typeof(IceCream));
                Flavour = allFlavours[Random.Shared.Next(allFlavours.Length)];
            }
        }

        public int GetSalesForecast()
        {
            var forecasts = new Dictionary<IceCream, int>
            {
                { IceCream.Strawberry, 9 },
                { IceCream.Vanilla, 11 },
                { IceCream.Chocolate, 3 }
            };
            return forecasts[Flavour ?? throw new NullReferenceException("flavour is null")];
        }
    }
}