import datetime

import scorer
from scorer import IceCream


def print_scoreboard():
    now = datetime.datetime.now()
    print_scoreboard_at(now)


def do_update_selection():
    scorer.update_selection()


def print_scoreboard_at(now, selection=do_update_selection):
    names = ["Steve", "Julie", "Francis"]
    print(f"Scoreboard at time {now}")
    for name in names:
        print_score(name, selection)


def print_score(name, selection=do_update_selection):
    if name == "Steve":
        scorer.flavour = IceCream.Strawberry
    else:
        selection()
    score = scorer.get_score()
    print(f"{name} score: {score}")
