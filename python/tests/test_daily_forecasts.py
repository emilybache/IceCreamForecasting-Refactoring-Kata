import datetime
import approvaltests

from daily_forecasts import print_sales_forecasts, print_sales_forecase_and_update_selection
from scorer import IceCream
import scorer


def stub_update_selection():
    scorer.flavour = IceCream.Vanilla


def test_sales_forecasts(capsys):
    print_sales_forecase_and_update_selection(
        now=datetime.datetime.fromisoformat("2023-05-08 15:26:03.797869"),
        update_selection=stub_update_selection
    )
    output = capsys.readouterr()
    approvaltests.verify(output.out)
