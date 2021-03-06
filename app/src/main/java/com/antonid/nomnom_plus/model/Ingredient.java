package com.antonid.nomnom_plus.model;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by antonid on 5.7.16.
 */
public class Ingredient {
    private String name;
    private ArrayList<Integer> recipes;
    private boolean isChecked;

    public Ingredient(String name, String recipes, int isChecked){
        this.name = name;
        this.recipes = parseRecipesString(recipes);
        this.isChecked = isChecked == 1;

    }

    private ArrayList<Integer> parseRecipesString(String recipes){
        ArrayList<Integer> converted = new ArrayList<>();
        String[] numbers = recipes.split(",");

        try {
            for (String number : numbers) {
                converted.add(Integer.getInteger(number));
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Problem with parse string" + recipes);
        }

        return converted;
    }
}
