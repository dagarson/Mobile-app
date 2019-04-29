package edu.kvcc.cis298.beveragetracker;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BeverageLab {

    //static instance of BeverageLab
    private static  BeverageLab sBeverageLab;

    //list of Beverages
    private List<Beverage> mBeverages;


    public static BeverageLab get(Context context) {
        if(sBeverageLab == null) {
            sBeverageLab = new BeverageLab(context);
        }
        return sBeverageLab;
    }

    //called when a new instance of BeverageLab is created
    private BeverageLab(Context context) {
        mBeverages = new ArrayList<>();
        putBeverageList(context);
    }

    //return arrayList of Beverages
    public List<Beverage> getBeverages() {
        return mBeverages;
    }


    //match Beverage with Beverage in list
    public Beverage getBeverage(String wineNum) {
        for(Beverage beverage : mBeverages) {
            if(beverage.getWineNumber()
                    .equals(wineNum)) {
                return beverage;
            }
        }
        //if no Beverage is found
        return null;
    }

    //read the data file and put in arrayList
    private void putBeverageList(Context context) {
        Scanner scanner = null;

        //try to read csv file
        try {
            scanner = new Scanner(context.getResources().openRawResource(R.raw.beverage_list));

            // loop through data and store each line
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String parts[] = line.split(",");


                //split file in appropriate part
                String Number = parts[0];
                String Description = parts[1];
                String Pack = parts[2];
                String Price = parts[3];
                String Active = parts[4];


                //get/set active t/f status
                boolean isActive;
                if (Active.equals("True")) {
                    isActive = true;
                } else {
                    isActive = false;
                }


                // adds new instance of a Beverage to arrayList
                mBeverages.add(new Beverage(Number, Description,
                        Pack,Price, isActive));
            }

            //Catch
        } catch (Exception e) {

        } finally {
            // Finally close file
            scanner.close();
        }
    }
}