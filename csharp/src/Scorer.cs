using System;
using System.Collections.Generic;
using System.Text;

namespace IceCreamScorer
{
    public class Scorer
    {
        public int GetScore() 
        {
            //bool sunnyToday = lookupWeather();
            //switch (flavour)
            //{
            //    case Strawberry:
            //        if (sunnyToday)
            //            return 10;
            //        else
            //            return 5;
            //    case Chocolate:
            //        return 6;
            //    case Vanilla:
            //        if (sunnyToday)
            //            return 7;
            //        else
            //            return 5;
            //    default:
            //        return -1;
            //}
        }
        public void setFlavour(IceCream iceCreamFlavour) 
        {
            flavour = iceCreamFlavour;
        }
        public void updateSelection() 
        {
            // placeholder implementation - real version would use machine learning to predict sales
           //throw std::runtime_error("Machine learning subsystem which another team has not implemented yet");
        }
        private bool lookupWeather() 
        {
            // placeholder implementation - real version would make API call to weather service
            //throw std::runtime_error("API call to weather service which can't be called from unit test");
        }


        private IceCream flavour = IceCream.Strawberry;
    };
}
