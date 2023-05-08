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
    return get_score_for_flavour_and_weather(flavour, sunny_today)


def get_score_for_flavour_and_weather(current_flavour, sunny_today):
    if current_flavour == IceCream.Strawberry:
        if sunny_today:
            return 10
        else:
            return 5
    elif current_flavour == IceCream.Chocolate:
        return 6
    elif current_flavour == IceCream.Vanilla:
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
