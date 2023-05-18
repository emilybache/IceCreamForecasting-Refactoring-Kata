using System;
using System.Collections.Generic;

namespace IceCreamScorer
{
    public class DailyForecasts
    {
        private readonly Scorer scorer;
        public DailyForecasts(Scorer scorer)
        {
            this.scorer = scorer;
        }

        public void PrintSalesForecasts()
        {
            var names = new List<string>() { "Steve", "Julie", "Francis" };
            Console.WriteLine($"Scoreboard at time: {DateTime.Now:ddd MMM dd hh:mm:ss yyyy}");

            foreach (var name in names)
            {
                if (name == "Steve")
                {
                    scorer.Flavour = IceCream.Strawberry;
                }
                else
                {
                    scorer.UpdateSelection();
                }
                int score = scorer.GetScore();
                Console.WriteLine($"{name} score: {score}");
            }
        }
    }
}
