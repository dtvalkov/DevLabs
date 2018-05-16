package com.example.mitko.tastyapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class LatestFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;

    public LatestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LatestFragment.
     */
    public static LatestFragment newInstance() {
        return new LatestFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupRecyclerView();
        setupSwipeRefresh();


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void setupSwipeRefresh() {

        swipeRefreshLayout.setOnRefreshListener(() -> {
            Handler mHandler = new Handler();//In UI Thread
            mHandler.postDelayed(() -> swipeRefreshLayout.setRefreshing(false), 500);
        });
    }




    private void setupRecyclerView() {

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);         // Use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // Create 5 mock meals
        Meal[] meals = new Meal[5];

        for (int i = 0; i < 5; i++) {
            meals[i] = new Meal();         }         // Specify an adapter
        RecyclerView.Adapter mAdapter = new MealAdapter(meals);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new SpacesItemDecoration(2,50, true));
    }



}