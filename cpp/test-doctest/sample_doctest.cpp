#include "ApprovalTests.hpp"
#include "doctest/doctest.h"
#include "Scorer.h"

TEST_CASE("Scorer") {
    // TODO: make this pass
    Scorer scorer;
    int score = scorer.getScore();
    REQUIRE(-1 == score);
}


TEST_CASE ("Scoreboard") {
    //TODO: finish this test
    //printScoreboard();

    SUBCASE("sample section") {
        REQUIRE(true == false);
    }
}



