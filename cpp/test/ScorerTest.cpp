#define APPROVALS_GOOGLETEST
#include <gtest/gtest.h>
#include "../src/Scorer.h"

using namespace std;

TEST(ScorerTest, scorer)
{
    // TODO: make this pass
    Scorer scorer;
    scorer.setFlavour(Strawberry);
    int score = scorer.getScore([](Scorer *scorer) { return true; });
    ASSERT_EQ(10, score);
}
