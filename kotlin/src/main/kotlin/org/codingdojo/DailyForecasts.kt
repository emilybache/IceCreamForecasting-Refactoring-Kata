package org.codingdojo

import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class DailyForecasts {

    private val scorer: Scorer = Scorer()

    fun printSalesForecasts() {
        val names = listOf("Steve", "Julie", "Francis")
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.from(ZoneOffset.UTC))
        println("Forecast at: " + formatter.format(Instant.now()))
        for (name in names) {
            if (name == "Steve") {
                Scorer.flavour = IceCream.Strawberry
            } else {
                scorer.updateSelection()
            }
            val score: Int = scorer.getSalesForecast()
            println("$name score: $score")
        }
    }
}
