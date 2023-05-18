from long_range_forecasts import long_range_forecast_for_weather
from scorer import IceCream


def test_long_range_forecast_for_weather():
    def stub_update_selection_and_lookup_weather(days_forward):
        return True

    result = long_range_forecast_for_weather("Q3", stub_update_selection_and_lookup_weather)
    assert result == {IceCream.Vanilla: 15,
                      IceCream.Chocolate: 12,
                      IceCream.Strawberry: 12}
