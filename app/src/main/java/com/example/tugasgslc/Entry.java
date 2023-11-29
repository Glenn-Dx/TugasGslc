package com.example.tugasgslc;

public abstract class Entry {

    private String foodName;
    private double calories;


    public Entry(String foodName, double calories) {
        this.foodName = foodName;
        this.calories = calories;
    }

    public void setFood(String food){
        this.foodName = food;
    }
    public void setCalories(double calories){
        this.calories = calories;
    }
    public String getFoodName() {
        return foodName;
    }
    public double getCalories() {
        return calories;
    }

    public abstract String getDetails();
}
