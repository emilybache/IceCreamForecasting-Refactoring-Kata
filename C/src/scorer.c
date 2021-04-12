#include <stdlib.h>

#include "scorer.h"

enum IceCream flavour;

int getScore() {
    bool sunnyToday = lookupWeather();
    switch (flavour) {
        case strawberry:
            if (sunnyToday)
                return 10;
            else
                return 5;
        case chocolate:
            return 6;
        case vanilla:
            if (sunnyToday)
                return 7;
            else
                return 5;
        default:
            return -1;
    }
}

bool lookupWeather()
{
    // placeholder implementation - real version would make API call to weather service
    bool sunny = rand() % 2;
    return sunny;
}

void updateSelection()
{
    // placeholder implementation - real version would use machine learning to predict sales
    int randNum = rand() % 4;
    flavour = randNum;
}
