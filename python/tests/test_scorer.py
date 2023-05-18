import scorer
from scorer import get_score, IceCream, lookup_weather

def test_scorer():
    assert get_score() == -1

def test_lookup_weather():
    assert lookup_weather() == True
