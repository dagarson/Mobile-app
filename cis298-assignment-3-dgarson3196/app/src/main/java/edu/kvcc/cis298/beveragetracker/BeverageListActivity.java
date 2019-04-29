package edu.kvcc.cis298.beveragetracker;

import android.support.v4.app.Fragment;


public class BeverageListActivity extends SingleFragmentActivity {

    // inherits from SingleFragmentActivity
    protected Fragment createFragment() {
        return new BeverageListFragment();
    }
}
