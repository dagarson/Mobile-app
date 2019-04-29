package edu.kvcc.cis298.beveragetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class BeverageListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    //Adapter for RecyclerView
    private bevAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate instance of RecyclerView
        View v = inflater.inflate(R.layout.fragment_beverage_list, container, false);

        // link RecyclerView To Layout and return view
        mRecyclerView = (RecyclerView) v.findViewById(R.id.beverage_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        BeverageLab beverageLab = BeverageLab.get(getActivity());
        //fill list with list from Singleton
        List<Beverage> beverages = beverageLab.getBeverages();

        //if adapter is null create  new one in recyclerview
        if(mAdapter == null) {
            mAdapter = new bevAdapter(beverages);
            mRecyclerView.setAdapter(mAdapter);
        }
        //else notify of changed data
        else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class BeverageHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        // declare variables for Instance of EACH Beverage
        private TextView mBeverageNameTextView, mBeverageItemNumberTextView, mBeveragePriceTextView;
        private Beverage mBeverage;

        // Constructor to accepts a view
        public BeverageHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            mBeverageNameTextView = (TextView) itemView.findViewById(R.id.list__beverage_name);
            mBeverageItemNumberTextView = (TextView) itemView.findViewById(R.id.list_beverage_num);
            mBeveragePriceTextView = (TextView) itemView.findViewById(R.id.list_beverage_price);
        }

        //  bind the layout to each beverage
        public void bind(Beverage beverage) {
            mBeverage = beverage;
            mBeverageNameTextView.setText(mBeverage.getWineDescription());
            mBeverageItemNumberTextView.setText(mBeverage.getWineNumber());
            mBeveragePriceTextView.setText("$" + mBeverage.getWinePrice());
        }

        @Override
        public void onClick(View view) {
            Intent intent = BeveragePager.newIntent(getActivity(), mBeverage.getWineNumber());
            startActivity(intent);
        }
    }

    // used to create RecylerView
    private class bevAdapter
            extends RecyclerView.Adapter<BeverageHolder> {
        private List<Beverage> mBeverages;

        //set list from sent list
        public bevAdapter(List<Beverage> beverages) {
            mBeverages = beverages;
        }

        @Override
        public BeverageHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item_beverage,
                    viewGroup, false);
            return new BeverageHolder(v);
        }

        //binds holder to beverage
        @Override
        public void onBindViewHolder(BeverageHolder holder, int i) {
            Beverage beverage = mBeverages.get(i);
            holder.bind(beverage);
        }

        //return list size
        @Override
        public int getItemCount() {
            return mBeverages.size();
        }
    }
}