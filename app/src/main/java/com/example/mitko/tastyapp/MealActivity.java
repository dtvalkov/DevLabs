package com.example.mitko.tastyapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.ShareActionProvider;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealActivity extends AppCompatActivity {


    public static void start(Context context, Meal meal) {//starter pattern
        Intent intent = new Intent(context, MealActivity.class);
        intent.putExtra("title", meal.getTitle());
        intent.putExtra("imageUrl", meal.getImgUrl());
        intent.putExtra("instructions", meal.getInstructions());
        intent.putExtra("cuisine", meal.getCuisine());
        intent.putExtra("url", meal.getUrl());

        custom_meal = meal;

        context.startActivity(intent);
    }

    @BindView(R.id.container)
    LinearLayout container;
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

    private static Meal custom_meal = null;
    private ShareActionProvider provider;
    private static Menu action_menu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        fillUiFromIntent();
        clickText();

        cuisineTextView.setPaintFlags(cuisineTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        hyperlinkTextView.setPaintFlags(hyperlinkTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        if (custom_meal.getUrl() == null)//премахване на view за хиперлинк, ако такъв не съществува
            hyperlinkTextView.setVisibility(View.GONE);
    }

    private void fillIngredients() {
        Meal meal = new Meal();
        List<Pair<String, String>> ingredients = meal.getIngredients();
        int size = ingredients.size();
        for (int i = 0; i < size; i++) {
            Pair<String, String> pair = ingredients.get(i);
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.format("%s %s", pair.first, pair.second));
            container.addView(checkBox, 3 + i);
        }
    }


    private void fillUiFromIntent() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imageUrl = intent.getStringExtra("imageUrl");
        String cuisine = intent.getStringExtra("cuisine");
        String instructions = intent.getStringExtra("instructions");
        String url = intent.getStringExtra("url");

        setTitle(title);
        Glide.with(this)
                .load(imageUrl)
                .into(imageDetail);

        cuisineTextView.setText(cuisine);
        fulltextTextView.setText(instructions);


        fillIngredients();

    }


    public void clickText() {
        hyperlinkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("url")));
                startActivity(browser);
            }
        });
    }

@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);

        MenuItem item = menu.findItem(R.id.action_share);
        provider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(item);

    provider.setShareIntent(doShare());

        action_menu = menu; //инициализираме глобалната променлива action_menu, за да я използваме при промяна на иконките
        return true;
    }


    public Intent doShare()
    {
            String send = ""; String subj = "";

            if (custom_meal != null) {
                send = "Виж рецепта за " + custom_meal.getTitle() + " на адрес: " + custom_meal.getUrl();
                subj = custom_meal.getTitle() + " recipe";
            }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,subj);
        intent.putExtra(Intent.EXTRA_TEXT, send);


        return intent;
    }

    private void setShareIntent(Intent shareIntent) {
        if (provider != null) {
            provider.setShareIntent(shareIntent);
        }
    }
@Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {


            case R.id.action_back://action - back
                this.finish();
                return true;


            case R.id.action_fav:

//               MenuItem favs = (MenuItem) findViewById(R.id.action_fav);
                Snackbar.make(findViewById(R.id.coordinator_layout), "1 item added", Snackbar.LENGTH_SHORT)
                        .setAction("UNDO",new View.OnClickListener(){

                                @Override
                                    public void onClick(View view)
                                {

                                }

                                })
                        .show();

               //action_menu.findItem(2).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_black_24dp));



                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

}
