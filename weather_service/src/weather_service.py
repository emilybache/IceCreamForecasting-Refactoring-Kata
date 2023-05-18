from flask import Flask
from flask import request
from datetime import datetime

app = Flask("weather-forecast")


@app.route("/forecast", methods=['GET'])
def forecast():
    latitude = request.args["latitude"]
    longitude = request.args["longitude"]
    days_forward = request.args["days_forward"]
    latitude = float(latitude)
    longitude = float(longitude)
    days_forward = float(days_forward)

    return forecast_for(days_forward, latitude, longitude)


def forecast_for(days_forward, latitude, longitude):
    aare = (63.3990, 13.0815)
    stockholm = (59.3293, 18.0686)
    if latitude == aare[0] and days_forward == 0:
        weather = {
            "main": "Snow",
            "description": "moderate snow",
            "temperature": {
                "average_daytime": "-3",
                "minimum": "-5",
                "maximum": "-1",
            },
            "visibility": 30,
            "wind": {
                "speed": 0.62,
                "direction": 349,
                "gust": 1.18
            },
            "precipitation": {
                "snow": {
                    "total": 3.7,
                    "pre_dawn": 0.5,
                    "morning": 1.0,
                    "afternoon": 2.2,
                    "evening": 0.0
                }
            },
            "clouds": {
                "pre_dawn": 50,
                "morning": 100,
                "afternoon": 100,
                "evening": 75
            }
        }
    elif latitude == stockholm[0] and True:
        weather = {
            "main": "Sunny",
            "description": "fine weather with few clouds",
            "temperature": {
                "average_daytime": "20",
                "minimum": "14",
                "maximum": "23",
            },
            "visibility": 10000,
            "wind": {
                "speed": 0.62,
                "direction": 182,
                "gust": 1.1
            },
            "precipitation": {
            },
            "clouds": {
                "pre_dawn": 30,
                "morning": 10,
                "afternoon": 0,
                "evening": 0
            }}
    elif latitude == stockholm[0]:
        weather = {
            "main": "Sunny periods",
            "description": "Dry but generally cloudy with sunny periods",
            "temperature": {
                "average_daytime": "18.5",
                "minimum": "9",
                "maximum": "20",
            },
            "visibility": 10000,
            "wind": {
                "speed": 0.82,
                "direction": 120,
                "gust": 1.2
            },
            "precipitation": {
            },
            "clouds": {
                "pre_dawn": 30,
                "morning": 50,
                "afternoon": 70,
                "evening": 80
            }}
    else:
        weather = {"main": "Cloudy"}
    result = {
        "latitude": latitude,
        "longitude": longitude,
        "days_forward": days_forward,
        "todays_date": datetime.today().isoformat(),
        "weather": weather
    }

    return result




if __name__ == "__main__":
    app.run(port=3005)
