import {IceCream} from "./IceCream";
import {Scorer} from "./Scorer";

export class DailyForecasts {
    private readonly scorer = new Scorer();

    printSalesForecasts(): void {
        const names = [ "Steve", "Julie", "Francis"];
        const formatter = (date: Date): string => date.toISOString().split('-')[0]
        console.log("Forecast at: " + formatter(new Date()));

        for (const name of names) {
            if (name === "Steve")
            {
                Scorer.flavour = IceCream.Strawberry;
            }
            else
            {
                this.scorer.updateSelection();
            }
            const score = this.scorer.getSalesForecast();
            console.log(name + " score: " + score);
        }
    }
}
