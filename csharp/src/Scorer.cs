using System;

namespace IceCreamScorer
{
    public class Scorer
    {
        public int GetScore() 
        {
            bool sunnyToday = LookupWeather();
            switch (Flavour)
            {
                case IceCreamFlavors.Strawberry:
                    if (sunnyToday)
                        return 10;
                    else
                        return 5;
                case IceCreamFlavors.Chocolate:
                    return 6;
                case IceCreamFlavors.Vanilla:
                    if (sunnyToday)
                        return 7;
                    else
                        return 5;
                default:
                    return -1;
            }
        }
        public IceCreamFlavors Flavour { private get; set; } = IceCreamFlavors.Strawberry;
        public void UpdateSelection() 
        {
            // placeholder implementation - real version would use machine learning to predict sales
            throw new NotImplementedException("Machine learning subsystem which another team has not implemented yet");
        }
        private bool LookupWeather() 
        {
            // placeholder implementation - real version would make API call to weather service
            throw new NotImplementedException("API call to weather service which can't be called from unit test");
        }
    };
}
