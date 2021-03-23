#include <stdlib.h>
#include <stdexcept>
#include <functional>
#include "Scorer.h"
#include "WeatherService.h"
#include "MachineLearningSubsystem.h"


int Scorer::getScore(const std::function<bool()> &doLookupWeather) {
    bool sunnyToday = doLookupWeather();
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
    predictSelection();
}

void Scorer::setFlavour(IceCream iceCreamFlavour) {
    flavour = iceCreamFlavour;
}

int Scorer::getScore() {
    return getScore([]() { return lookupWeather(); });
}
