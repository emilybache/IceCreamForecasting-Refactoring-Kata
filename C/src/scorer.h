#ifndef CATEGORIZER_H
#define CATEGORIZER_H

#include <stdbool.h>

enum IceCream
{
    strawberry, chocolate, vanilla
};

extern enum IceCream flavour;

int getScore();
bool lookupWeather();
void updateSelection();

#endif //CATEGORIZER_H
