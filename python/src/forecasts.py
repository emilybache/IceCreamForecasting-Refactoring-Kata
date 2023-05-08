import datetime

import scorer
from scorer import IceCream


def print_sales_forecasts():
    now = datetime.datetime.now()

    def update_selection():
        scorer.update_selection()

    update_sales_forecast_with_selection(now, update_selection)


def update_sales_forecast_with_selection(now, update_selection):
    names = ["Steve", "Julie", "Francis"]
    print(f"Forecast at time {now}")
    for name in names:
        if name == "Steve":
            scorer.flavour = IceCream.Strawberry
        else:
            update_selection()
        score = scorer.get_sales_forecast()
        print(f"{name} score: {score}")
