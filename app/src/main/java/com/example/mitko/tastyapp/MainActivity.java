package com.example.mitko.tastyapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

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
   @Nullable @BindView(R.id.navigation)
   public BottomNavigationView navigation;

     public static Boolean flagLatest, flagRandom, flagFavs = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> false;


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


        ButterKnife.bind(this);
        ButterKnife.setDebug(true);

        showFragment(LatestFragment.newInstance());

        /*  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = findViewById(R.id.message); */
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

/*
        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int i;
        switch (item.getItemId()) {
            case R.id.navigation_home:

                    showFragment(LatestFragment.newInstance());
                 return true;

            case R.id.navigation_dashboard:

                showFragment(RandomFragment.newInstance());

                return true;

            case R.id.navigation_notifications:


                showFragment(FavoritesFragment.newInstance());

                return true;


        }

        return false;
    }


    private void showFragment(AppFragments fragment) {

        String backStateName = fragment.getClass().getName();

        FragmentManager fragmentManager = getSupportFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0);


        if (!fragmentPopped) {

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.frame_layout, fragment);
            transaction.addToBackStack(backStateName);
            transaction.commit();

        }

    }

    }
