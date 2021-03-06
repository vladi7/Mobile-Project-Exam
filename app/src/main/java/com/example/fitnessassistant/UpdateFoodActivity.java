// INSPIRED BY: https://medium.com/@bhawanthagunawardana/android-sqlite-database-crud-s-with-example-application-4f5a841da8f6
package com.example.fitnessassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateFoodActivity extends AppCompatActivity {
    // set the default day for weekday
    private String record="Monday";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);
        // adds a spinner
        Spinner weekDays = (Spinner) findViewById(R.id.spinner);
        // adapter for arrays
        ArrayAdapter<String> adpt = new ArrayAdapter<String>(UpdateFoodActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.weekDays));
        // sets the dropdown
        adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weekDays.setAdapter(adpt);

        weekDays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                switch(position){
                    case 0:
                        record="Monday";
                        break;
                    case 1:
                        record = "Tuesday";
                        break;
                    case 2:
                        record="Wednesday";
                        break;
                    case 3:
                        record="Thursday";
                        break;
                    case 4:
                        record="Friday";
                        break;
                    case 5:
                        record="Saturday";
                        break;
                    case 6:
                        record="Sunday";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
    public void updateButtonPressed(View view) {


        EditText workoutInfo = findViewById(R.id.teRecipe);


        String workoutInfoNew = workoutInfo.getText().toString();
        // calls the database to update the food record
        DatabaseHandler.updateFoodUsingName(record, workoutInfoNew);
        Toast.makeText(this, "Food Schedule updated", Toast.LENGTH_SHORT).show();


        workoutInfo.setText("");
    }
}