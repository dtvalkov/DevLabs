package com.example.mitko.tastyapp;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitko on 10.5.2018 г..
 */

@SuppressWarnings("DefaultFileTemplate")
class Meal {

    String title;
    String imgUrl;
    String cuisine;
    String instructions;
    String origurl;
    List<Pair<String, String>> ingredients;

    public String getTitle() {
        return "Pancake";
    }

    public String getImgUrl() {
        return "https://static01.nyt.com/images/2017/03/24/dining/24COOKING-CLASSICPANCAKES/24COOKING-CLASSICPANCAKES-articleLarge.jpg";
    }

    public String getInstructions() {

        return "Put the flour, eggs, milk, 1 tbsp oil and a pinch of salt into a bowl or large jug, then whisk to a smooth batter.\n" +
                "Set aside for 30 mins to rest if you have time, or start cooking straight away.\n" +
                "Set a medium frying pan or crêpe pan over a medium heat and carefully wipe it with some oiled kitchen paper.\n" +
                "When hot, cook your pancakes for 1 min on each side until golden, keeping them warm in a low oven as you go.\n" +
                "Serve with lemon wedges and sugar, or your favourite filling.\n" +
                "Once cold, you can layer the pancakes between baking parchment, then wrap in cling film and freeze for up to 2 months.";
    }


    public String getCuisine() {return "American"; }
    public String getUrl() {return "https://www.themealdb.com/meal.php?c=52854"; }


    public List<Pair<String, String>> getIngredients() {
        List<Pair<String, String>> ingredients = new ArrayList<>(5);
        ingredients.add(new Pair<>("100g", "Flour"));
        ingredients.add(new Pair<>("2", "Large Eggs"));
        ingredients.add(new Pair<>("300ml", "Milk"));
        ingredients.add(new Pair<>("1tbsp", "Sunflower Oil"));
        ingredients.add(new Pair<>("to serve", "Sugar"));
        return ingredients;
    }

}
