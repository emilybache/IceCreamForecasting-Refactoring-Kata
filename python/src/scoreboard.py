import datetime

import scorer
from scorer import IceCream


def print_scoreboard():
    now = datetime.datetime.now()
    print_scoreboard_at(now)


def print_scoreboard_at(now):
    names = ["Steve", "Julie", "Francis"]
    print(f"Scoreboard at time {now}")
    for name in names:
        print_score(name)


def print_score(name):
    if name == "Steve":
        scorer.flavour = IceCream.Strawberry
    else:
        scorer.update_selection()
    score = scorer.get_score()
    print(f"{name} score: {score}")
