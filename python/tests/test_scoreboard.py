import datetime

import approvaltests

import scorer
from scoreboard import print_scoreboard


def stub_update_selection():
    scorer.flavour = scorer.IceCream.Chocolate


def test_scoreboard(capsys):
    print_scoreboard(datetime.datetime.fromisoformat("2023-05-08 10:12:37.023834"),
                     update_selection=stub_update_selection,
                     weather=True)
    captured = capsys.readouterr()
    approvaltests.verify(captured.out)
