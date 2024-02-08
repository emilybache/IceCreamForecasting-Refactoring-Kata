import {IceCream, IceCreamValues} from "./IceCream";

type DaysForward = number;
type Location = [number, number];

export class Scorer {

    static flavour: IceCream | null = null;

    getScore(): number {
        const sunnyToday = this.lookupWeather();
        if (Scorer.flavour === null) {
            return -1;
        } else {
            switch (Scorer.flavour)
            {
                case IceCream.Strawberry:
                    if (sunnyToday)
                        return 10;
                    else
                        return 5;
                case IceCream.Chocolate:
                    return 6;
                case IceCream.Vanilla:
                    if (sunnyToday)
                        return 7;
                    else
                        return 5;
                default:
                    return -1;
            }
        }
    }

    lookupWeather(something?: DaysForward | Location): boolean {
        // placeholder implementation - real version would make API call to weather service
        return Math.random() < 0.5;
    }

    updateSelection(): void {
        // placeholder implementation - real version would use machine learning to predict sales
        const score = this.getScore();
        if (score > 5) {
            const randomizeInt = (length: number): number => Math.round(Math.random() * length);
            const allFlavours = IceCreamValues;
            Scorer.flavour = allFlavours[randomizeInt(allFlavours.length)];
        }
    }

    getSalesForecast(): number {
        const forecasts = new Map<IceCream, number>([
            [IceCream.Strawberry, 9],
            [IceCream.Vanilla, 11],
            [IceCream.Chocolate, 3],
        ]);
        return forecasts.get(Scorer.flavour!)!;
    }
}