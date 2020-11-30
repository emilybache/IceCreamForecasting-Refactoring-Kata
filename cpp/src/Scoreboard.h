#ifndef ICECREAM_REFACTORING_KATA_SCOREBOARD_H
#define ICECREAM_REFACTORING_KATA_SCOREBOARD_H


#include <string>
#include "Scorer.h"

class Scoreboard {
public:
    Scoreboard(Scorer &scorer) : scorer(scorer) {};

    void printScoreboard();

    void printScore(std::string name);

private:
    Scorer &scorer;
};


#endif //ICECREAM_REFACTORING_KATA_SCOREBOARD_H
