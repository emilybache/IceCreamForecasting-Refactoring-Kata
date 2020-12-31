using System;
using System.Collections.Generic;
using System.Text;

namespace IceCreamScorer
{
    public class Scoreboard
    {
        private Scorer scorer;
        public Scoreboard(Scorer scorer)
        {
            this.scorer = scorer;
        }

        public void printScoreboard()
        {
            //std::vector < std::string> names = { "Steve","Julie","Francis"};
            //time_t rawtime = std::time(nullptr);
            //tm* localtime = std::localtime(&rawtime);
            //std::cout << "Scoreboard at time: " << std::asctime(localtime) << "\n";

            //for (auto name: names)
            //    printScore(name);
        }

        public void printScore(string name)
        {
            //if (name == "Steve")
            //{
            //    scorer.setFlavour(Strawberry);
            //}
            //else
            //{
            //    scorer.updateSelection();
            //}
            //int score = scorer.getScore();
            //std::cout << name << " score: " << score << "\n";
        }
    }
}
