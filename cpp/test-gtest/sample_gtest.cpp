#include <gtest/gtest.h>

#include "Scoreboard.h"

using namespace std;

TEST(ScorerTest, scorer)
{
    // TODO: make this pass
    Scorer scorer;
    int score = scorer.getScore();
    ASSERT_EQ(-1, score);
}

TEST(ScoreboardTest, scorer)
{
    //TODO: finish this test
    //printScoreboard();
}


