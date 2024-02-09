import {Scorer} from "./Scorer";
import {IceCream, IceCreamValues} from "./IceCream";

export class LongRangeForecasts {

    private readonly scorer = new Scorer();

    public longRangeForecast(quarter: string): Map<IceCream, number> {
        const result = new Map<IceCream, number>();
        if (quarter === "Q1" || quarter === "Q4") {
            for (const flavour of IceCreamValues) {
                result.set(flavour, 5);
            }
        }
        for (const flavour of IceCreamValues) {
            result.set(flavour, 0);
        }
        const interestingDates = [
            new Date("2023-05-01T14:00:00.000-07:00"),
            new Date("2023-05-18T14:00:00.000-07:00"),
            new Date("2023-06-05T14:00:00.000-07:00"),
            new Date("2023-06-23T14:00:00.000-07:00"),
        ];
        const expectedWeather: boolean[] = [];
        for (const  interestingDate of interestingDates) {
            this.scorer.updateSelection();
            const forecastDate = new Date("2023-04-26T14:00:00.000-07:00");
            const daysForward= Math.floor(Math.abs(forecastDate.getTime() - interestingDate.getTime()) / (1000 * 3600 * 24));
            const lookupWeather = this.scorer.lookupWeather(daysForward);
            expectedWeather.push(lookupWeather);
        }

        for (const flavour of  result.keys()) {
            result.set(flavour, result.get(flavour) + 10);
            const sunnyHolidays = expectedWeather.filter(s => s).length;
            if (sunnyHolidays > 2 && flavour == IceCream.Vanilla) {
                result.set(flavour, result.get(flavour) + 5);
            }
            if (sunnyHolidays > 1 && expectedWeather.at(1)) {
                result.set(flavour, result.get(flavour) + 2);
            }
        }
        return result;
    }
}
