import enum
import random


class IceCream(enum.Enum):
    Strawberry = 1
    Chocolate = 2
    Vanilla = 3


flavour = None


def get_score():
    sunny_today = lookup_weather()
    global flavour
    if flavour == IceCream.Strawberry:
        if sunny_today:
            return 10
        else:
            return 5
    elif flavour == IceCream.Chocolate:
        return 6
    elif flavour == IceCream.Vanilla:
        if sunny_today:
            return 7
        else:
            return 5
    else:
        return -1


def lookup_weather():
    # placeholder implementation - real version would make API call to weather service
    sunny = random.choice([True, False])
    return bool(sunny)


def update_selection():
    score = get_score()
    if score > 5:
        global flavour
        # placeholder implementation - real version would use machine learning to predict sales
        flavour = random.choice([IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla])


def get_sales_forecast():
    forecasts = {
        IceCream.Strawberry: 9,
        IceCream.Vanilla: 11,
        IceCream.Chocolate: 3
    }
    return forecasts[flavour]
