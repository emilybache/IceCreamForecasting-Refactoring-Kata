#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"
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

    SECTION("sample section") {
        REQUIRE(true == false);
    }
}


