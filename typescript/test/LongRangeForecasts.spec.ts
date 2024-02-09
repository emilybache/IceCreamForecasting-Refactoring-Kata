import {LongRangeForecasts} from "../src/LongRangeForecasts";

import {describe, expect, test} from "vitest";
import {IceCream, IceCreamName} from "../src/IceCream";
import {readApprovalFirstLineOf, readApprovalLinesOf} from "./Approval";
import path from "path";

const printIceCreamForecast = (actual: Map<IceCream, number>): string => {
    const printedResult: string[] = [];
    printedResult.push("{");
    const sortedKeys = [...actual.keys()];
    sortedKeys.sort();
    for (const key of sortedKeys) {
        printedResult.push(IceCreamName(key));
        printedResult.push(":");
        printedResult.push(actual.get(key).toString());
        printedResult.push(", ");
    }
    printedResult.push("}");
    return printedResult.join('');
}

describe('LongRangeForecasts', () => {
    test('long range forecast', () => {
        const quarter = "Q3";
        const actual = new LongRangeForecasts().longRangeForecast(quarter);
        const printedResult = printIceCreamForecast(actual);

        expect(printedResult).toBe(readApprovalFirstLineOf(path.resolve(__dirname, "LongRangeForecasts.longRangeForecast.approved.txt")));
    });
});