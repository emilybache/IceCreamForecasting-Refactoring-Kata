import scorer
from scorer import IceCream
import datetime

def long_range_forecast(quarter: str):
    def update_selection_and_lookup_weather(days_forward):
        scorer.update_selection()
        weather = scorer.lookup_weather(days_forward=days_forward)
        return weather

    return long_range_forecast_for_weather(quarter, update_selection_and_lookup_weather)


def long_range_forecast_for_weather(quarter, update_selection_and_lookup_weather):
    result = {}
    if quarter == "Q1" or quarter == "Q4":
        for flavour in IceCream:
            result[flavour] = 5
    for flavour in IceCream:
        result[flavour] = 0
    interesting_dates = [
        datetime.date.fromisoformat("2023-05-01"),
        datetime.date.fromisoformat("2023-05-18"),
        datetime.date.fromisoformat("2023-06-05"),
        datetime.date.fromisoformat("2023-06-23"),
    ]
    expected_weather = []
    for day in interesting_dates:
        days_forward = (day - datetime.date.fromisoformat("2023-04-26")).days
        weather = update_selection_and_lookup_weather(days_forward)
        expected_weather.append(weather)
    for flavour in IceCream:
        result[flavour] += 10
        sunny_holidays = len([True for d in expected_weather if expected_weather])
        if sunny_holidays > 2 and flavour == IceCream.Vanilla:
            result[flavour] += 5
        elif sunny_holidays > 1 and expected_weather[1]:
            result[flavour] += 2
    return result


