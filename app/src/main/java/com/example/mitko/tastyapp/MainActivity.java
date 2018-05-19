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


import java.util.List;
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

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.navigation_latest:
               checkFrag(fragmentManager, transaction, new LatestFragment());
                break;

            case R.id.navigation_random:
                checkFrag(fragmentManager, transaction, new RandomFragment());
                break;

            case R.id.navigation_favorites:
                checkFrag(fragmentManager, transaction, new FavoritesFragment());
                break;
        }
        transaction.commit();
        return true;
    }



    private void showFragment(AppFragments fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String tag = fragment.getClass().getSimpleName();
        transaction.add(R.id.frame_layout, fragment, tag);
        transaction.commit();


    }


    private static void checkFrag(FragmentManager fragmentManager,
                                      FragmentTransaction transaction, Fragment fragment) {

        String tag = fragment.getClass().getSimpleName();
        Fragment cachedFragment = fragmentManager.findFragmentByTag(tag);
        List<Fragment> addedFragments = fragmentManager.getFragments();

        for (Fragment tempFragment : addedFragments) {
            if (tempFragment.isVisible())
                transaction.hide(tempFragment);
        }
        if (cachedFragment != null) {
            transaction.show(cachedFragment);
        } else {
            transaction.add(R.id.frame_layout, fragment, tag);
        }
    }


}
