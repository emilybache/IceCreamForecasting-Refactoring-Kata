#ifndef ICECREAM_REFACTORING_KATA_SCORER_H
#define ICECREAM_REFACTORING_KATA_SCORER_H

enum IceCream {
    Strawberry,
    Chocolate,
    Vanilla
};

class Scorer {
public:
    int getScore();
    void setFlavour(IceCream iceCreamFlavour);
    void updateSelection();

private:
    bool lookupWeather();


    IceCream flavour = Strawberry;
};


#endif //ICECREAM_REFACTORING_KATA_SCORER_H
