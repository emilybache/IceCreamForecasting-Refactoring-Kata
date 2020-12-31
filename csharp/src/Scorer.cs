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
                case IceCreamFlavours.Strawberry:
                    if (sunnyToday)
                        return 10;
                    else
                        return 5;
                case IceCreamFlavours.Chocolate:
                    return 6;
                case IceCreamFlavours.Vanilla:
                    if (sunnyToday)
                        return 7;
                    else
                        return 5;
                default:
                    return -1;
            }
        }
        public IceCreamFlavours Flavour { private get; set; } = IceCreamFlavours.Strawberry;
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
