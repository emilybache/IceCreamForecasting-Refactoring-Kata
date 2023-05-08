import datetime

import approvaltests

import scorer
from forecasts import update_sales_forecast_with_selection


def stub_update_selection():
    scorer.flavour = scorer.IceCream.Chocolate


def test_scoreboard(capsys):
    update_sales_forecast_with_selection(datetime.datetime.fromisoformat("2023-05-08 10:12:37.023834"),
                                         update_selection=stub_update_selection)
    captured = capsys.readouterr()
    approvaltests.verify(captured.out)
