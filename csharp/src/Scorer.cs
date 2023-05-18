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
                case IceCream.Strawberry:
                    if (sunnyToday)
                        return 10;
                    else
                        return 5;
                case IceCream.Chocolate:
                    return 6;
                case IceCream.Vanilla:
                    if (sunnyToday)
                        return 7;
                    else
                        return 5;
                default:
                    return -1;
            }
        }
        public IceCream Flavour { private get; set; } = IceCream.Strawberry;
        public void UpdateSelection() 
        {
            // placeholder implementation - real version would use machine learning to predict sales
            throw new NotImplementedException("Machine learning subsystem which another team has not implemented yet");
        }
        public bool LookupWeather(String location = null, int daysForward = 0) 
        {
            // placeholder implementation - real version would make API call to weather service
            throw new NotImplementedException("API call to weather service which can't be called from unit test");
        }
    };
}
