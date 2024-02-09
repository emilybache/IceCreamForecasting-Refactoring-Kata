package org.codingdojo

import org.approvaltests.Approvals
import org.junit.jupiter.api.Test
import java.util.*

class LongRangeForecastsTest {

    @Test
    fun longRangeForecast() {
        val quarter = "Q3"
        val actual = LongRangeForecasts().longRangeForecast(quarter)
        val printedResult = printIceCreamForecast(actual)
        Approvals.verify(printedResult)
    }

    private fun printIceCreamForecast(actual: Map<IceCream, Int>): StringBuilder {
        val printedResult = StringBuilder()
        printedResult.append("{")
        val sortedKeys = ArrayList(actual.keys)
        Collections.sort(sortedKeys)
        for (key in sortedKeys) {
            printedResult.append(key)
            printedResult.append(":")
            printedResult.append(actual[key])
            printedResult.append(", ")
        }
        printedResult.append("}")
        return printedResult
    }

}