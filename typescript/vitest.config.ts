import {defineConfig} from "vitest/config";

export default defineConfig({
    test: {
        coverage: {
            reportOnFailure: true,
            provider: 'istanbul',
            enabled: true,
            reporter: ['html']
        },
    }
})