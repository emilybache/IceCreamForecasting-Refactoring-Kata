<?php


namespace IceCream;


use DateTime;

class Scoreboard
{
    private Scorer $scorer;

    public function __construct(Scorer $scorer)
    {
        $this->scorer = $scorer;
    }

    public function printScoreboard(): void
    {
        $names = ["Steve","Julie","Francis"];

        echo "Scoreboard at time: " . (new DateTime())->format('r') . "\n";

        foreach ($names as $name) {
            $this->printScore($name);
        }
    }

    public function printScore(string $name): void
    {
        if ($name == "Steve") {
            $this->scorer->setFlavour('Strawberry');
        } else {
            $this->scorer->updateSelection();
        }
        $score = $this->scorer->getScore();
        echo "{$name} score: {$score}\n";
    }
}