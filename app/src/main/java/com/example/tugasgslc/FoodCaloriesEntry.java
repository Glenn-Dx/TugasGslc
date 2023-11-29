package com.example.tugasgslc;

public class FoodCaloriesEntry extends Entry{

    public FoodCaloriesEntry(String foodName, double calories){
        super(foodName, calories);
    }

    @Override
    public String getDetails(){
        return getFoodName() + " -> " + getCalories() + " cal";
    }

}
