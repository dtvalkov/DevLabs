package com.example.mitko.tastyapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This is the starting screen for the TastyApp
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            return false;
        }
    };


    /**
     *
     *
     * @param resID
     */




    private void setText(int resID){
        mTextMessage.setText(resID);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        setupSwipeRefresh();

      /*  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
/*
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.navigation_latest);
                return true;
            case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.navigation_random);
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.navigation_favorites);
                return true;
        }
*/
        return false;
    }


    private void setupSwipeRefresh() {
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swiperefresh_layout);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            Handler mHandler = new Handler();//In UI Thread
            mHandler.postDelayed(() -> swipeRefreshLayout.setRefreshing(false), 500);
        });
    }




    private void setupRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
          mRecyclerView.setHasFixedSize(true);         // Use a linear layout manager
          RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
         mRecyclerView.setLayoutManager(mLayoutManager);
        // Create 5 mock meals
        Meal[] meals = new Meal[5];

        for (int i = 0; i < 5; i++) {
            meals[i] = new Meal();         }         // Specify an adapter
          RecyclerView.Adapter mAdapter = new MealAdapter(meals);
        mRecyclerView.setAdapter(mAdapter);     }



    }
