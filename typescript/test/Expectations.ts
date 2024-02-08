import {MockInstance} from "vitest";
import {expect} from "vitest";

export const expectMockCalled = (consoleMock: MockInstance<unknown[], unknown>) => (line) => expect(consoleMock).toHaveBeenCalledWith(line);
