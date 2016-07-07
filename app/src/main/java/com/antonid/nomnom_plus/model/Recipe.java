package com.antonid.nomnom_plus.model;

import java.util.ArrayList;

/**
 * Created by antonid on 7.7.16.
 */
public class Recipe {
    private String name;
    private ArrayList<Integer> ingredients;
    private String howToCook;
    private boolean isAvailable;
    private int numberOfSteps;
    private float timeForCooking;
    private String numberOfEveryIngredient;
    private String measureOfTime;
    private int numberOfIngredients;


    public Recipe(String name, String ingredients, String howToCook, boolean isAvailable,
                  int numberOfSteps, float timeForCooking, String numberOfEveryIngredient,
                  String measureOfTime, int numberOfIngredients) {
        this.name = name;
        this.ingredients = parseIngredientsString(ingredients);
    }

    private ArrayList<Integer> parseIngredientsString(String ingredients){
        ArrayList<Integer> converted = new ArrayList<>();
        String[] numbers = ingredients.split("\\D");

        try {
            for (String number : numbers) {
                converted.add(Integer.getInteger(number));
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Problem with parse string" + ingredients);
        }

        return converted;
    }
}
