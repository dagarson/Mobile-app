package edu.kvcc.cis298.beveragetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import java.util.List;


public class BeveragePager extends FragmentActivity {


    // variable holds pager layout
    private ViewPager mViewPager;

    //variable holds list of beverages
    private List<Beverage> mBeverages;

    //variable hold string for Intent call
    private static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.cis298assignment3.beverage_id";

    public static Intent newIntent(Context context, String beverageId) {

        //new intent and puts in extra
        Intent intent = new Intent(context, BeveragePager.class);
        intent.putExtra(EXTRA_BEVERAGE_ID, beverageId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beverage_pager);

        // Get the beverageId out of the intent that was used to get this activity started.
        String beverageId = getIntent().getStringExtra(EXTRA_BEVERAGE_ID);

        // get handle to viewpager
        mViewPager = (ViewPager) findViewById(R.id.beverage_view_pager);

        // get List of Beverages from BeverageLab
        mBeverages = BeverageLab.get(this).getBeverages();


        FragmentManager fragmentManager = getSupportFragmentManager();

        // set Adapter for the viewpager
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                Beverage beverage = mBeverages.get(i);
                return BeverageFragment.newInstance(beverage.getWineNumber());
            }

            @Override
            public int getCount() {
                return mBeverages.size();
            }
        });

        // loops through Beverages for selected Beverage then sets viewpager
        for (int i = 0; i < mBeverages.size(); i++) {
            if (mBeverages.get(i).getWineNumber().equals(beverageId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}