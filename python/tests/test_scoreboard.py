import datetime

import approvaltests

from scoreboard import print_scoreboard_at


def test_scoreboard(capsys):
    print_scoreboard_at(datetime.datetime.fromisoformat("2023-05-08 10:12:37.023834"))
    captured = capsys.readouterr()
    approvaltests.verify(captured.out)
