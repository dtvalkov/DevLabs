package com.example.mitko.tastyapp;

/**
 * Created by Mitko on 10.5.2018 г..
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;


class MealAdapter extends RecyclerView.Adapter<MealAdapter.ViewHolder> {
    private Meal[] mDataset;





    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is a Meal in this case
      //  public ImageView imageView;
        //public TextView textView;


        /*
        *
        *  butterknife binding
         */
      @Nullable
      @BindView(R.id.imageView1) ImageView imageView;
      @Nullable  @BindView(R.id.title_textview) TextView textView;
      @BindView(R.id.container) LinearLayout container;





        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            ButterKnife.setDebug(true);

            // imageView = view.findViewById(R.id.imageView1);
           // textView = view.findViewById(R.id.title_textview);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MealAdapter(Meal[] myDataset) {


        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Meal meal = mDataset[position];
        holder.textView.setText(meal.getTitle());
        ImageView imageView = holder.imageView;
        final Context context = imageView.getContext();
        Glide.with(context).load(meal.getImgUrl()).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//stretching the image

        holder.container.setOnClickListener(v -> {
            MealActivity.start(context, meal);
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }



}
