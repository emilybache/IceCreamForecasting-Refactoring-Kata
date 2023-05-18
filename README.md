IceCream Refactoring Kata
==========================

Get the code under test. These functions display some or all of these properties which make the functions hard to test:

- Missing Input
- Side Effects
- Non-deterministic

Suggested order to tackle it in:

- Scorer
- LongRangeForecasts 
- DailyForecasts 

Address the factors that make them hard to test so that you end up testing pure functions.

Weather Service
----------------

Not every language version has code to use it (yet) but there is an actual Weather Service provided in the folder "weather_service". You should be able to run it with python like this:

	cd weather_service
	python -m pip install -r requirements.txt
	cd src
	python weather_service.py
	
