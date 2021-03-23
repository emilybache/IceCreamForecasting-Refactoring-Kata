#include <stdlib.h>
#include <stdexcept>
#include "Scorer.h"


int Scorer::getScore() {
    bool sunnyToday = lookupWeather();
    return getScore(sunnyToday);
}

int Scorer::getScore(bool sunnyToday) const {
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
