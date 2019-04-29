package edu.kvcc.cis298.temperatureconverter;


//Daniel Garson
//CIS 298
//Due 2-13-19




public class Conversion{

   int mfrom;
   int mto;
   double mUserInput;

   double mConvert = 0;
   private String mType = "";

    public Conversion(int from, int to, double ui) {
        mfrom = from;
        mto = to;
        mUserInput = ui;
        tempType();
    }


    public void tempType() {

        //Test to see if trying to convert to the same type
        if(mfrom == mto) {
            mConvert = mUserInput;
            mType = "Same type NO conversion";
        }

        //Convert Celsius to ...
        if(mfrom == 0) {
            switch (mto) {

                //Fahrenheit
                case 1:
                    mConvert = mUserInput * 9/5 + 32;
                    mType = "[°F] = ([°C] x 9/5) + 32";
                    break;

                //Kelvin
                case 2:
                    mConvert = mUserInput + 273.15;
                    mType = "[K] = ([°C] + 273.15)";
                    break;

            }
        }

        //Convert Fahrenheit to ...
        if(mfrom == 1) {
            switch (mto) {

                //Celsius
                case 0:
                    mConvert = (mUserInput - 32) * 5/9;
                    mType = "[°C] = ([°F] - 32) x 5/9";
                    break;

                //Kelvin
                case 2:
                    mConvert = (mUserInput + 459.67) * 5/9;
                    mType ="[K] = ([°F] + 459.67) x 5/9";
                    break;

            }
        }

        //Convert Kelvin to ...
        if(mfrom == 2) {
            switch (mto) {

                //Celsius
                case 0:
                    mConvert = (mUserInput - 273.15);
                    mType = "[°C] = [K] - 273.15";
                    break;

                //Fahrenheit
                case 1:
                    mConvert = (mUserInput * 9/5 - 459.67);
                    mType = "[°F] = ([K] x 9/5 - 459.67)";
                    break;

            }
        }


    }

    //get type and conversion and return them
    public double Convert() {
        return mConvert;
    }
    public String getType() {
        return mType;
    }
}