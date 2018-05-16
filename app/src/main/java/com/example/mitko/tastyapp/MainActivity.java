package com.example.mitko.tastyapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This is the starting screen for the TastyApp
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    /*
    *
    * Butterknife binding
    * */
   @Nullable @BindView(R.id.message)
   public TextView mTextMessage;
   @Nullable @BindView(R.id.navigation_home)
   public BottomNavigationView navigation;
    @BindView(R.id.swiperefresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;


//TextView mTextMessage; BottomNavigationView navigation;

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

        navigation = findViewById(R.id.navigation_dashboard);
        mTextMessage = findViewById(R.id.message);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);


        /*  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = findViewById(R.id.message);
        //BottomNavigationView navigation = findViewById(R.id.navigation);
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






    }
