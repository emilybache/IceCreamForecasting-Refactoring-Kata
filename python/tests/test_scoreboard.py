import datetime

import approvaltests

from scoreboard import print_scoreboard_at, do_update_selection


def stub_update_selection():
    pass


def test_scoreboard(capsys):
    print_scoreboard_at(datetime.datetime.fromisoformat("2023-05-08 10:12:37.023834"),
                        selection=stub_update_selection)
    captured = capsys.readouterr()
    approvaltests.verify(captured.out)
