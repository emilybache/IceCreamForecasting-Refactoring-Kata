using System;
using System.Collections.Generic;

namespace IceCreamScorer
{
    public class DailyForecasts
    {
        private readonly Scorer scorer = new Scorer();

        public void PrintSalesForecasts()
        {
            var names = new List<string> { "Steve", "Julie", "Francis" };
            Console.WriteLine($"Forecast at: {DateTime.UtcNow:yyyy-MM-dd}");

            foreach (var name in names)
            {
                if (name == "Steve")
                {
                    Scorer.Flavour = IceCream.Strawberry;
                }
                else
                {
                    scorer.UpdateSelection();
                }
                int score = scorer.GetSalesForecast();
                Console.WriteLine($"{name} score: {score}");
            }
        }
    }
}