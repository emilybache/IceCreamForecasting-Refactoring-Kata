import enum
import random
import requests


class IceCream(enum.Enum):
    Strawberry = 1
    Chocolate = 2
    Vanilla = 3


flavour = None


def get_score():
    sunny_today = lookup_weather()
    return get_score_with_weather_and_flavour(sunny_today, flavour)


def get_score_with_weather_and_flavour(sunny_today, current_flavour=None):
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


def lookup_weather(location=None, days_forward=None):
    location = location or (59.3293, 18.0686)  # default to Stockholm
    days_forward = days_forward or 0
    params = {"latitude": location[0], "longitude": location[1], "days_forward": days_forward}
    weather_app = "http://127.0.0.1:3005"
    try:
        response = requests.get(weather_app + "/forecast", params=params)
    except requests.exceptions.ConnectionError as err:
        raise RuntimeError("Weather service unavailable")
    if response.status_code != 200:
        raise RuntimeError("Weather service request failed")
    forecast = response.json()
    return bool(forecast["weather"]["main"] == "Sunny")


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
