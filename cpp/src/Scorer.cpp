#include <stdlib.h>
#include <stdexcept>
#include "Scorer.h"
#include "WeatherService.h"
#include "MachineLearningSubsystem.h"


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


void Scorer::updateSelection() {
    flavour = predictSelection();
}

void Scorer::setFlavour(IceCream iceCreamFlavour) {
    flavour = iceCreamFlavour;
}
