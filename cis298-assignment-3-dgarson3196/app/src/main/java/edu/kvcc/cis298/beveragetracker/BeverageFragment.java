package edu.kvcc.cis298.beveragetracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


public class BeverageFragment extends Fragment{

    // makes new Beverage in fragment
    private Beverage mBeverage;


    //  used to create new intent
    private static final String BEVERAGE_ID_NUMBER = "beverage_id";


    //declare variables
    private EditText mBeverageNumber, mBeveragePack, mBeveragePrice;
    private TextView mBeverageDescription;
    private CheckBox mBeverageActive;


    public static BeverageFragment newInstance(String beverageId) {
        Bundle args = new Bundle();
        args.putString(BEVERAGE_ID_NUMBER, beverageId);

        // Creates a new BeverageFragment
        BeverageFragment fragment = new BeverageFragment();

        // Set arguments and return
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String beverageId = getArguments()
                .getString(BEVERAGE_ID_NUMBER);
        mBeverage = BeverageLab.get(getActivity())
                .getBeverage(beverageId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Create view with fragment and inflater
        View v = inflater.inflate(R.layout.fragment_beverage, container, false);

        mBeverageDescription = (EditText) v.findViewById(R.id.W_description);
        mBeverageDescription.setText(mBeverage.getWineDescription());
        mBeverageDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing. The method must be overridden though, so here it is.
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count
            ) {
                mBeverage.setWineDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing. The method must be overridden though, so here it is.
            }
        });

        mBeverageNumber = (EditText) v.findViewById(R.id.beverage_ID);
        mBeverageNumber.setText(mBeverage.getWineNumber());
        mBeverageNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing. The method must be overridden though, so here it is.
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count
            ) {
                mBeverage.setmWineNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing. The method must be overridden though, so here it is.
            }
        });

        mBeveragePrice = (EditText) v.findViewById(R.id.w_price);
        mBeveragePrice.setText(mBeverage.getWinePrice());
        mBeveragePrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing. The method must be overridden though, so here it is.
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count
            ) {
                mBeverage.setmWinePrice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing. The method must be overridden though, so here it is.
            }
        });

        // set wine to the class variables and sets each layout
        mBeverageDescription = (TextView) v.findViewById(R.id.W_description);
        mBeverageDescription.setText(mBeverage.getWineDescription());

        mBeverageNumber = (EditText) v.findViewById(R.id.beverage_ID);
        mBeverageNumber.setText(mBeverage.getWineNumber());

        mBeveragePack = (EditText) v.findViewById(R.id.w_pack);
        mBeveragePack.setText(mBeverage.getWinePack());

        mBeveragePrice = (EditText) v.findViewById(R.id.w_price);
        mBeveragePrice.setText("$" +mBeverage.getWinePrice().toString());

        mBeverageActive = (CheckBox) v.findViewById(R.id.w_active_box);
        mBeverageActive.setChecked(mBeverage.getWineActive());
        mBeverageActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // set checkbox to active or inactive
                mBeverage.setWineActive(b);
            }
        });
        return v;
    }
}