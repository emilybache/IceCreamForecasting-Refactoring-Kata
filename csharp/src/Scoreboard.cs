using System;
using System.Collections.Generic;

namespace IceCreamScorer
{
    public class Scoreboard
    {
        private readonly Scorer scorer;
        public Scoreboard(Scorer scorer)
        {
            this.scorer = scorer;
        }

        public void PrintScoreboard()
        {
            var names = new List<string>() { "Steve", "Julie", "Francis" };
            Console.WriteLine($"Scoreboard at time: {DateTime.Now:ddd MMM dd hh:mm:ss yyyy}");

            foreach (var name in names)
                PrintScore(name);
        }

        public void PrintScore(string name)
        {
            if (name == "Steve")
            {
                scorer.setFlavour(IceCreamFlavors.Strawberry);
            }
            else
            {
                scorer.updateSelection();
            }
            int score = scorer.GetScore();
            Console.WriteLine($"{name} score: {score}");
        }
    }
}
