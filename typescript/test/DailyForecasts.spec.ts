import {describe, vi, it, afterAll, expect, beforeEach, MockInstance} from "vitest";
import {DailyForecasts} from "../src/DailyForecasts";
import path from 'path';
import {readApprovalLinesOf} from "./Approval";
import {expectMockCalled} from "./Expectations";

describe("DailyForecasts", () => {
    let consoleMock: MockInstance<unknown[], unknown>;

    beforeEach(() => {
        consoleMock = vi.spyOn(console, 'log').mockImplementation(() => undefined);
    })

    it("should sales forecast", () => {
        const forecasts = new DailyForecasts();

        forecasts.printSalesForecasts();

        readApprovalLinesOf(path.resolve(__dirname, "DailyForecasts.salesForecast.approved.txt")).forEach(expectMockCalled(consoleMock));
    });

    afterAll(() => {
        consoleMock.mockReset();
    })
});