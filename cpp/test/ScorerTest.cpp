#define APPROVALS_GOOGLETEST
#include <gtest/gtest.h>
#include "../src/Scorer.h"

using namespace std;

TEST(ScorerTest, scorer)
{
    Scorer scorer;
    scorer.setFlavour(Strawberry);
    int score = scorer.getScore(true);
    ASSERT_EQ(10, score);
}
