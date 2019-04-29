package edu.kvcc.cis298.beveragetracker;

public class Beverage {


    // declare variables
    private String mWineNumber, mWineDescription, mWinePack;
    private String mWinePrice;
    private Boolean mWineActive;

    // Empty Constructor
    public Beverage() {}

    // Constructor for new Beverage with all variables
    public Beverage(String number, String description,
                    String pack, String price,
                    Boolean active) {

        mWineNumber = number;
        mWineDescription = description;
        mWinePack = pack;
        mWinePrice = price;
        mWineActive = active;
    }


    public String getWineNumber() {
        return mWineNumber;
    }
    public void setmWineNumber(String wineNumber){
        mWineNumber  = wineNumber;
    }

    public String getWineDescription() {
        return mWineDescription;
    }

    public void setWineDescription(String description) {
        mWineDescription = description;
    }

    public String getWinePack() {
        return mWinePack;
    }

    public String getWinePrice() {
        return mWinePrice;
    }

    public void setmWinePrice(String winePrice){
        mWinePrice = winePrice;
    }


    public Boolean getWineActive() {
        return mWineActive;
    }

    public void setWineActive(Boolean active) {
        mWineActive = active;
    }


}