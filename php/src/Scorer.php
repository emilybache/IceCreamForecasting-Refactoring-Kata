<?php


namespace IceCream;


use RuntimeException;

class Scorer
{
    private string $flavour;

    public function setFlavour(string $iceCreamFlavour): void
    {
        $this->flavour = $iceCreamFlavour;
    }

    public function getScore(): int
    {
        $sunnyToday = $this->lookupWeather();
        switch ($this->flavour) {
            case 'Strawberry':
                if ($sunnyToday) {
                    return 10;
                } else {
                    return 5;
                }

            case 'Chocolate':
                return 6;

            case 'Vanilla':
                if ($sunnyToday) {
                    return 7;
                } else {
                    return 5;
                }

            default:
                return -1;
        }
    }

    public function updateSelection(): void
    {
        // placeholder implementation - real version would use machine learning to predict sales
        throw new RuntimeException('Machine learning subsystem which another team has not implemented yet');
    }

    private function lookupWeather(): bool
    {
        // placeholder implementation - real version would make API call to weather service
        throw new RuntimeException('API call to weather service which can\'t be called from unit test');
    }
}