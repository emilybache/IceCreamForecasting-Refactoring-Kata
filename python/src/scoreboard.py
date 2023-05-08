import datetime

import scorer
from scorer import IceCream


def print_scoreboard(now=None, update_selection=None, weather=None):
    now = now or datetime.datetime.now()
    names = ["Steve", "Julie", "Francis"]
    print(f"Scoreboard at time {now}")
    for name in names:
        print_score(name, update_selection, weather)


def print_score(name, update_selection=None, weather=None):
    def do_update_selection():
        scorer.update_selection()
    update_selection = update_selection or do_update_selection

    if name == "Steve":
        scorer.flavour = IceCream.Strawberry
    else:
        update_selection()
    score = scorer.get_score(sunny_today=weather)
    print(f"{name} score: {score}")
