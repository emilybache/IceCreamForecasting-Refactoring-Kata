import datetime

import scorer
from scorer import IceCream


def print_sales_forecasts(now=None):
    def update_selection():
        scorer.update_selection()

    print_sales_forecase_and_update_selection(now, update_selection)


def print_sales_forecase_and_update_selection(now, update_selection):
    names = ["Steve", "Julie", "Francis"]
    now = now or datetime.datetime.now()
    print(f"Forecast at time {now}")
    for name in names:
        if name == "Steve":
            scorer.flavour = IceCream.Strawberry
        else:
            update_selection()
        score = scorer.get_sales_forecast()
        print(f"{name} score: {score}")
