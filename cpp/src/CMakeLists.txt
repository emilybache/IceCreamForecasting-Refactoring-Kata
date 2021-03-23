set(SRC_LIB_NAME src)
add_library(${SRC_LIB_NAME} Scorer.cpp Scorer.h Scoreboard.cpp Scoreboard.h WeatherService.h MachineLearningSubsystem.h)
target_include_directories(${SRC_LIB_NAME} PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})
