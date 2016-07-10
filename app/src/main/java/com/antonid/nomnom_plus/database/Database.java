package com.antonid.nomnom_plus.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by antonid on 12.07.2015.
 */


import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import com.antonid.nomnom_plus.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;


    public static abstract class IngredientsTable implements BaseColumns{
        private static final String TABLE_NAME = "Ingredients";
        private static final String ID = "_id";
        private static final String NAME = "name";
        private static final String IS_CHECKED = "checked";
        private static final String FOR_WHAT_RECIPES = "forWhatRecipes";

    }

    public static abstract class RecipesTable implements BaseColumns{
        private static final String TABLE_NAME = "Recipes";
        private static final String NAME = "Name";
        private static final String ID = "_id";
        private static final String INGREDIENTS = "ingredients";
        private static final String HOW_TO_COOK = "howToCook";
        private static final String IS_AVAILABLE = "isAvailable";
        private static final String NUMBER_OF_STEPS = "numberOfSteps";
        private static final String TIME_FOR_COOKING = "timeForCooking";
        private static final String DESCRIPTION = "description";
        private static final String NUMBER_OF_PERSONS = "numberOfPersons";
        private static final String NUMBER_OF_EVERY_ING = "numberOfEveryIng";
        private static final String NUMBER_OF_INGREDIENTS = "numberOfIngredients";
        private static final String MEASURE_FOR_TIME = "measureForTime";
    }


    public static abstract class RecipesCategoriesTable implements BaseColumns{
        private static final String TABLE_NAME = "CategoriesOfRecipes";
        private static final String ID = "_id";
        private static final String NAME = "name";
        private static final String RECIPES = "recipes";
        private static final String NUMBER_OF_RECIPES = "numberOfRecipes";
        private static final String DESCRIPTION = "description";

    }

    public static abstract class CategoriesOfIngredientsTable implements BaseColumns{
        public static final String TABLE_NAME = "Categories";
        private static final String ID = "_id";
        private static final String NAME= "name";
        private static final String INGREDIENTS = "ingredients";
        private static final String NUMBER_OF_INGREDIENTS = "numberOfIngredients";
        private static final String EXAMPLE = "example";
    }


    public Database(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
        open();
    }


/*
    public  Database getInstance(Context context) {
        if (instance == null) {
            instance = new Database(context);
        }
        return instance;
    }
*/

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    String[] ingredientColums = {
            IngredientsTable.ID,
            IngredientsTable.NAME,
            IngredientsTable.FOR_WHAT_RECIPES,
            IngredientsTable.IS_CHECKED
    };

    public Ingredient getIngredient(String name){
        Cursor cursor = database.query(IngredientsTable.TABLE_NAME,
                ingredientColums, IngredientsTable.NAME + "=?",
                new String[] { name}, null, null, null, null);
        try {
            cursor.moveToFirst();
            Ingredient ingredient = new Ingredient(cursor.getString(1), cursor.getString(2),
                    cursor.getInt(3));
            return ingredient;
        } catch (NullPointerException e){
            throw new NullPointerException("Maybe there are not results for this name in database.");
        } finally {
            cursor.close();
        }
    }

    public ArrayList<Ingredient> getSelectedIngredients(){
        ArrayList<Ingredient> selectedIngredients = new ArrayList<>();

        Cursor cursor = database.query(IngredientsTable.TABLE_NAME,
                ingredientColums, IngredientsTable.NAME + "=?",
                null, null, null, null, null);

        cursor.moveToFirst();
        if (!cursor.isAfterLast()){
            do {
                if (cursor.getInt(3) != 0) {
                    selectedIngredients.add(new Ingredient(cursor.getString(1), cursor.getString(2),
                            cursor.getInt(3)));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return selectedIngredients;
    }
}

