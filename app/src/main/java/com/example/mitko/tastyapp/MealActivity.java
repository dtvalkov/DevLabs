package com.example.mitko.tastyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealActivity extends AppCompatActivity {

    @BindView(R.id.image_detail)
    ImageView imageDetail;
    @BindView(R.id.cuisine_text_view)
    TextView cuisineTextView;
    @BindView(R.id.instructions_text_view)
    TextView instructionsTextView;
    @BindView(R.id.fulltext_text_view)
    TextView fulltextTextView;
    @BindView(R.id.hyperlink_text_view)
    TextView hyperlinkTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        fillUiFromIntent();

    }



    private void fillUiFromIntent() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("bg.devlabs.androidacademy.title");
        String imageUrl = intent.getStringExtra("bg.devlabs.androidacademy.imageUrl");
        setTitle(title);
        Glide.with(this)
                .load(imageUrl)
                .into(imageDetail);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.action_back://action - back
             this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
