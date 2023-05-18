import datetime

import scorer
from scorer import IceCream


def print_sales_forecasts():
    names = ["Steve", "Julie", "Francis"]
    now = datetime.datetime.now()
    print(f"Forecast at time {now}")
    for name in names:
        if name == "Steve":
            scorer.flavour = IceCream.Strawberry
        else:
            scorer.update_selection()
        score = scorer.get_sales_forecast()
        print(f"{name} score: {score}")


