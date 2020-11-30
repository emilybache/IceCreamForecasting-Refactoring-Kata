#include <iostream>
#include <vector>
#include "Scoreboard.h"

void Scoreboard::printScoreboard() {
    std::vector<std::string> names = {"Steve","Julie","Francis"};
    time_t rawtime;
    struct tm * timeinfo;

    time ( &rawtime );
    timeinfo = localtime ( &rawtime );
    std::cout << "Scoreboard at time: " << asctime (timeinfo) << "\n";

    for(auto name: names)
        printScore(name);
}

void Scoreboard::printScore(std::string name) {
    if (name == "Steve")
    {
        scorer.setFlavour(Strawberry);
    }
    else
    {
        scorer.updateSelection();
    }
    int score = scorer.getScore();
    std::cout << name << " score: " << score << "\n";
}
