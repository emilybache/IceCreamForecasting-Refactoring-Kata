import scorer
from scorer import IceCream
import datetime

def long_range_forecast(quarter: str):
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
        scorer.update_selection()
        days_forward = (day - datetime.date.fromisoformat("2023-04-26")).days
        expected_weather.append(scorer.lookup_weather(days_forward=days_forward))

    for flavour in IceCream:
        result[flavour] += 10
        sunny_holidays = len([True for d in expected_weather if expected_weather])
        if sunny_holidays > 2 and flavour == IceCream.Vanilla:
            result[flavour] += 5
        elif sunny_holidays > 1:
            result[flavour] += 2
    return result
