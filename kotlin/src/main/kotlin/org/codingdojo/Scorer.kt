package org.codingdojo

import org.codingdojo.IceCream.Chocolate
import org.codingdojo.IceCream.Strawberry
import org.codingdojo.IceCream.Vanilla
import java.util.*

class Scorer {

    companion object {
        var flavour: IceCream? = null
    }

    fun getScore(): Int {
        val sunnyToday = lookupWeather()
        return if (flavour == null) {
            -1
        } else {
            when (flavour) {
                Strawberry -> if (sunnyToday) 10 else 5
                Chocolate -> 6
                Vanilla -> if (sunnyToday) 7 else 5
                else -> -1
            }
        }
    }

    fun lookupWeather(): Boolean {
        // placeholder implementation - real version would make API call to weather service
        return Random().nextBoolean()
    }

    fun lookupWeather(daysForward: Long): Boolean {
        // placeholder implementation - real version would make API call to weather service
        return Random().nextBoolean()
    }

    fun lookupWeather(location: Map.Entry<Double?, Double?>?): Boolean {
        // placeholder implementation - real version would make API call to weather service
        return Random().nextBoolean()
    }

    fun updateSelection() {
        // placeholder implementation - real version would use machine learning to predict sales
        val score = getScore()
        if (score > 5) {
            val randomizer = Random()
            val allFlavours = IceCream.values()
            flavour = allFlavours[randomizer.nextInt(allFlavours.size)]
        }
    }

    fun getSalesForecast(): Int {
        val forecasts = mutableMapOf(
            Strawberry to 9,
            Vanilla to 11,
            Chocolate to 3,
        )
        return forecasts[flavour]!!
    }


}
