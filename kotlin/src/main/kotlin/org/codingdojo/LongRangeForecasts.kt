package org.codingdojo

import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.List

class LongRangeForecasts {

    private val scorer = Scorer()

    fun longRangeForecast(quarter: String?): Map<IceCream, Int> {
        val result = HashMap<IceCream, Int>()
        if (quarter == "Q1" || quarter == "Q4") {
            for (flavour in IceCream.values()) {
                result[flavour] = 5
            }
        }
        for (flavour in IceCream.values()) {
            result[flavour] = 0
        }
        val interestingDates = List.of(
            Instant.parse("2023-05-01T14:00:00.000-07:00"),
            Instant.parse("2023-05-18T14:00:00.000-07:00"),
            Instant.parse("2023-06-05T14:00:00.000-07:00"),
            Instant.parse("2023-06-23T14:00:00.000-07:00"),
        )
        val expectedWeather: MutableList<Boolean> = ArrayList()
        for (interestingDate in interestingDates) {
            scorer.updateSelection()
            val forecastDate = Instant.parse("2023-04-26T14:00:00.000-07:00")
            val daysForward = ChronoUnit.DAYS.between(forecastDate, interestingDate)
            val lookupWeather = scorer.lookupWeather(daysForward)
            expectedWeather.add(lookupWeather)
        }
        for (flavour in result.keys) {
            result[flavour] = result[flavour]!! + 10
            val sunnyHolidays = expectedWeather.stream().filter { s: Boolean? -> s!! }.count()
            if (sunnyHolidays > 2 && flavour === IceCream.Vanilla) {
                result[flavour] = result[flavour]!! + 5
            }
            if (sunnyHolidays > 1 && expectedWeather[1]) {
                result[flavour] = result[flavour]!! + 2
            }
        }
        return result
    }
}
