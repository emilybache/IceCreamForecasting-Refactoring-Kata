import approvaltests

from scorer import get_score, get_score_from_flavour_and_weather, IceCream


def print_score_scenario(args, result):
    return f"{args} \t=> \tscore={result}\n"


def test_scorer():
    flavours = [IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla]
    weathers = [True, False]
    approvaltests.verify_all_combinations(
        get_score_from_flavour_and_weather,
        [
            flavours,
            weathers,
        ],
        formatter=print_score_scenario
    )
