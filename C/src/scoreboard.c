
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#include "scoreboard.h"
#include "scorer.h"

void printScoreboard()
{
    const char *names[] = {"Steve","Julie","Francis"};
    time_t rawtime;
    struct tm * timeinfo;

    time ( &rawtime );
    timeinfo = localtime ( &rawtime );
    printf ( "Scoreboard at time: %s\n", asctime (timeinfo) );

    for (int i = 0; i < 3; ++i) {
        printScore(names[i]);
    }
}

void printScore(const char *name) {
    if (strcmp(name, "Steve") == 0)
    {
        flavour = strawberry;
    }
    else
    {
        updateSelection();  
    }
    int score = getScore();
    printf("%s score: %d\n", name, score);
}

