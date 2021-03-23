#define APPROVALS_GOOGLETEST
#include <gtest/gtest.h>
#include "../src/Scorer.h"

using namespace std;

TEST(ScorerTest, scorer)
{
    // TODO: make this pass
    Scorer scorer;
    int score = scorer.getScore();
    ASSERT_EQ(-1, score);
}
