import approvaltests

from forecasts import print_sales_forecasts


def test_sales_forecasts(capsys):
    print_sales_forecasts()
    output = capsys.readouterr()
    assert output.out == ""
