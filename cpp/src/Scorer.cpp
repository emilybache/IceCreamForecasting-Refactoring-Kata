#include <stdlib.h>
#include <stdexcept>
#include <functional>
#include "Scorer.h"


int Scorer::getScore(const std::function<bool(Scorer *)> &doLookupWeather) {
    bool sunnyToday = doLookupWeather(this);
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
    throw std::runtime_error("API call to weather service which can't be called from unit test");
}

void Scorer::updateSelection() {
    // placeholder implementation - real version would use machine learning to predict sales
    throw std::runtime_error("Machine learning subsystem which another team has not implemented yet");
}

void Scorer::setFlavour(IceCream iceCreamFlavour) {
    flavour = iceCreamFlavour;
}

int Scorer::getScore() {
    return getScore([](Scorer *scorer) { return scorer->lookupWeather(); });
}
