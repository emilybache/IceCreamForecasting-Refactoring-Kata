#include <stdlib.h>
#include "Scorer.h"


int Scorer::getScore() {
    bool sunnyToday = lookupWeather();
    switch (flavour) {
        case Strawberry:
            if (sunnyToday)
                return 10;
            else
                return 5;
        case Chocolate:
            return 6;
        case Vanilla:
            if (sunnyToday)
                return 7;
            else
                return 5;
        default:
            return -1;
    }
}

bool Scorer::lookupWeather() {
        // placeholder implementation - real version would make API call to weather service
    bool sunny = rand() % 2;
    return sunny;
}

void Scorer::updateSelection() {
    // placeholder implementation - real version would use machine learning to predict sales
    int randNum = rand() % 4;
    flavour = static_cast<IceCream>(randNum);
}

void Scorer::setFlavour(IceCream iceCreamFlavour) {
    flavour = iceCreamFlavour;
}
