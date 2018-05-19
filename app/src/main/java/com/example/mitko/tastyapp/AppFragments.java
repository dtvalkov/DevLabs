package com.example.mitko.tastyapp;

import android.app.Fragment;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Mitko on 17.5.2018 г..
 */

@SuppressWarnings("DefaultFileTemplate")
public class AppFragments extends android.support.v4.app.Fragment { // базов клас за фрагментите в приложението



  //  public static String getFragTag() {return this.getTag(); }

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



    public static  android.support.v4.app.Fragment getFragmentByTagName(FragmentManager fragmentManager, String fragmentTagName)//функция за търсене на фрагмент по зададен таг
    { //използва се при повторно извикване на вече създаден фрагмент
        android.support.v4.app.Fragment  ret = null;

        // Get all Fragment list.
        List<android.support.v4.app.Fragment> fragmentList = fragmentManager.getFragments();

        if(fragmentList!=null)
        {
            int size = fragmentList.size();
            for(int i=0;i<size;i++)
            {
               android.support.v4.app.Fragment fragment =  fragmentList.get(i);

                if(fragment!=null) {
                    String fragmentTag = fragment.getTag();

                    // If Fragment tag name is equal then return it.
                    if (fragmentTag.equals(fragmentTagName)) {
                        ret = fragment;
                    }
                }
            }
        }

        return ret;
    }


}
