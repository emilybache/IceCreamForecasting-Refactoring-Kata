import {describe, expect, it} from "vitest";
import {Scorer} from "../src/Scorer";

describe('Scorer', () => {
    it('should get score', () => {
        const scorer = new Scorer();
        expect(scorer.getScore()).toBe(-1);
    });
});