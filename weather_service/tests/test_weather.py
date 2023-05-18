import multiprocessing
import pytest
import requests
import time

import weather_service
from weather_service import app

TEST_PORT = 3006


def server(port):
    app.run(port=port)


def wait_for_server_to_start(server_url):
    started = False
    while not started:
        try:
            requests.get(server_url)
            started = True
        except Exception as e:
            time.sleep(0.2)


@pytest.fixture(autouse=True, scope="session")
def weather_app():
    """ starts the weather app running on localhost """
    p = multiprocessing.Process(target=server, args=(TEST_PORT,))
    p.start()
    server_url = f"http://127.0.0.1:{TEST_PORT}"
    wait_for_server_to_start(server_url)
    yield server_url
    p.terminate()


def test_forecast_local():
    expected = {'days_forward': 1,
                'latitude': 63.399,
                'longitude': 13.0815,
                'todays_date': 'today',
                'weather': {'main': 'Cloudy'}}
    actual = weather_service.forecast_for(1, 63.3990, 13.0815)
    actual['todays_date'] = "today" # scrub date to make deterministic
    assert actual == expected


def test_forecast(weather_app):
    params = {"latitude": 100, "longitude": 200, "days_forward": 3}
    response = requests.get(weather_app + "/forecast", params=params)
    assert response.status_code == 200
