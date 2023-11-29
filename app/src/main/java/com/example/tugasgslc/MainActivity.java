package com.example.tugasgslc;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Entry> entries = new ArrayList<>();
    private double caloriesTotal;

    private TextInputEditText foodNameEditText;
    private TextInputEditText caloriesEditText;
    private TextView totalCaloriesView;
    private TextView errorTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodNameEditText = findViewById(R.id.foodName);
        caloriesEditText = findViewById(R.id.calories);
        totalCaloriesView = findViewById(R.id.totalCalories);
        errorTextEditText = findViewById(R.id.errorText);

        Button addButton = findViewById(R.id.add);

        setButtonClickHandler(addButton);
    }
    //function untuk update kalori total di atas kiri
    private void updateCalories(double input) {
        caloriesTotal += input;
        totalCaloriesView.setText("Total Calories: " + caloriesTotal);
    }

    // function untuk update TextList
    private void updateList() {
        ListView foodListView = findViewById(R.id.foodList);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);


        for (Entry entry : entries) {
            if (entry instanceof FoodCaloriesEntry) {
                adapter.add(((FoodCaloriesEntry) entry).getDetails());
            }
        }

        foodListView.setAdapter(adapter);
    }

    //function untuk menghandle logik buton click
    private void setButtonClickHandler(Button addButton) {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String foodName = foodNameEditText.getText().toString();
                    String caloriesString = caloriesEditText.getText().toString();
                    double calories = Double.parseDouble(caloriesString);

                    FoodCaloriesEntry temp = new FoodCaloriesEntry(foodName, calories);
                    entries.add(temp);


                    updateCalories(calories);

                    updateList();

                    foodNameEditText.getText().clear();
                    caloriesEditText.getText().clear();
                    errorTextEditText.setText("");
                } catch (NumberFormatException e) {
                    errorTextEditText.setText("Invalid calories input");
                }
            }
        });
    }
}
