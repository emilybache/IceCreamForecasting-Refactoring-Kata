import approvaltests
import pytest
import requests

import scorer
from scorer import get_score, IceCream, get_score_with_weather_and_flavour


def print_get_score(args, result):
    return f"{args} => {result}\n"


def test_get_score_with_weather():
    weathers = [True, False]
    flavours = [IceCream.Strawberry, IceCream.Chocolate, IceCream.Vanilla, None]
    approvaltests.verify_all_combinations(
        get_score_with_weather_and_flavour,
        [
            weathers,
            flavours,
        ],
        formatter=print_get_score
    )


class StubWeatherServiceResponse:
    def __init__(self):
        self.status_code = 200

    def json(self):
        return {"weather": {"main": "Sunny"}}


def test_lookup_weather_default_location(monkeypatch):
    def stub_requests_get(*args, **kwargs):
        return StubWeatherServiceResponse()

    monkeypatch.setattr(requests, "get", stub_requests_get)
    assert scorer.lookup_weather() == True


@pytest.mark.vcr
def test_lookup_weather_not_sunny():
    location_aare = (63.3990, 13.0815)
    assert scorer.lookup_weather(location_aare) == False


@pytest.mark.skip("this test is too fragile to be worth maintaining")
def test_get_score(monkeypatch):
    def stub_lookup_weather():
        return True

    monkeypatch.setattr(scorer, "lookup_weather", stub_lookup_weather)
    monkeypatch.setattr(scorer, "flavour", IceCream.Vanilla)

    def mock_get_score_with_weather(sunny_today, flavour):
        assert sunny_today == True
        assert flavour == IceCream.Vanilla
        return 0

    monkeypatch.setattr(scorer, "get_score_with_weather", mock_get_score_with_weather)
    assert scorer.get_score() == 0
