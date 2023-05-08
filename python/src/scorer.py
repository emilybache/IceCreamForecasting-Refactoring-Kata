import enum
import random


class IceCream(enum.Enum):
    Strawberry = 1
    Chocolate = 2
    Vanilla = 3


flavour = None


def get_score(current_flavour=None, sunny_today=None):
    sunny_today = sunny_today if sunny_today is not None else lookup_weather()
    current_flavour = current_flavour or flavour
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
    # placeholder implementation - real version would use machine learning to predict sales
    global flavour
    flavour = random.choice([IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla])
