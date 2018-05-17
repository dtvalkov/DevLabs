package com.example.mitko.tastyapp;

import android.app.Fragment;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Mitko on 17.5.2018 г..
 */

public class AppFragments extends android.support.v4.app.Fragment { // базов клас за фрагментите в приложението


    protected void setupSwipeRefresh(SwipeRefreshLayout srl) {

        srl.setOnRefreshListener(() -> {
            Handler mHandler = new Handler();//In UI Thread
            mHandler.postDelayed(() -> srl.setRefreshing(false), 500);
        });
    }




    protected void setupRecyclerView(RecyclerView rv, int num) {

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rv.setHasFixedSize(true);         // Use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rv.setLayoutManager(mLayoutManager);
        // Create 5 mock meals
        Meal[] meals = new Meal[num];

        for (int i = 0; i < num; i++) {
            meals[i] = new Meal();         }         // Specify an adapter
        RecyclerView.Adapter mAdapter = new MealAdapter(meals);
        rv.setAdapter(mAdapter);

        rv.addItemDecoration(new SpacesItemDecoration(2,50, true));
    }



}
