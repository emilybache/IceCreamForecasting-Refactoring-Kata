using Xunit;
using IceCreamScorer;

namespace IceCreamScorer.Tests
{
    public class ScorerTest
    {
        [Fact]
        public void GetScore()
        {
            var scorer = new Scorer();
            Assert.Equal(-1, scorer.GetScore());
        }
    }
}
