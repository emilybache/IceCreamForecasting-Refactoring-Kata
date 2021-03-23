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
    int getScore(const std::function<bool()> &doLookupWeather);
    void setFlavour(IceCream iceCreamFlavour);
    void updateSelection();

private:
    IceCream flavour = Strawberry;
};


#endif //ICECREAM_REFACTORING_KATA_SCORER_H
