package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import Model.Factory;
import Model.Field;
import Model.FieldDataInterface;

public class MainActivity4 extends AppCompatActivity {
    private Spinner spinner;
    private ListView listView;
    private  String Age;
private TextView   PartextView ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        PartextView =findViewById(R.id.textView6);
        Intent intent = getIntent();

       Age= intent.getStringExtra("Age");
        //fill the spinner
        FillSpinner();
        // Show the list View According to selected Item In Spinner
        ShowList();


        //HandleListClicked
        HandleListClicked();
    }

    private void HandleListClicked() {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Get selected item and spinner value
                    String selectedItem = parent.getItemAtPosition(position).toString();  // Get the clicked item from ListView
                    String selectedSpinner = spinner.getSelectedItem().toString();  // Get the selected item from Spinner

                    // Log selected values for debugging
                    Log.d("SelectedList", selectedItem);
                    Log.d("SelectedSpinner", selectedSpinner);

                    // Determine what information to display based on the spinner and selected list item
                    if (selectedSpinner.equals("Food")) {
                        if (selectedItem.equals("Type Of Food")) {
                            PartextView.setText(getFoodTypeInfo(Age));
                        } else if (selectedItem.equals("Amount Of Food")) {
                            PartextView.setText(getFoodAmountInfo(Age));
                        } else if (selectedItem.equals("Time Of Food")) {
                            PartextView.setText(getFoodTimeInfo(Age));
                        }
                    } else {
                        // Default sleep info for age groups
                        PartextView.setText(getAgeBasedInfo(Age));
                    }
                }
            });
        }
        // Helper function to get age-related information for sleep
    private String getAgeBasedInfo(String age) {
        switch (age) {
            case "6+ years":
                return "Children aged 6+ years typically need 9-11 hours of sleep each night.";
            case "From Birth To 6 Months":
                return "Infants from birth to 6 months typically need 14-17 hours of sleep per day, including naps.";
            case "From 6 Months to 12 Months":
                return "Babies from 6 to 12 months typically need 12-16 hours of sleep per day, including naps.";
            case "From 3–5 years":
                return "Children from 3 to 5 years typically need 10-13 hours of sleep each night.";
            case "From 1–3 years":
                return "Toddlers from 1 to 3 years typically need 11-14 hours of sleep per day, including naps.";
            default:
                return "Please enter a valid age range.";
        }
    }

    private String getFoodTypeInfo(String age) {
        switch (age) {
            case "6+ years":
                return "Food suitable for children aged 6+ years: At this age, children can eat a variety of foods similar to what adults eat, but in smaller portions. Ensure a balanced diet with fruits, vegetables, whole grains, lean proteins, and dairy. Limit sugar and provide fiber for digestion.";
            case "From Birth To 6 Months":
                return "Food suitable for infants from birth to 6 months: Only breast milk or formula is needed. No solid foods are introduced yet.";
            case "From 6 Months to 12 Months":
                return "Food suitable for infants from 6 to 12 months: Start introducing solids like pureed fruits, vegetables, and iron-fortified cereals. Continue breastfeeding or formula feeding.";
            case "From 3–5 years":
                return "Food suitable for children from 3 to 5 years: Provide a balanced diet with fruits, vegetables, lean meats, whole grains, and dairy. Encourage healthy snacks and limit sugary foods.";
            case "From 1–3 years":
                return "Food suitable for toddlers from 1 to 3 years: Include a variety of fruits, vegetables, proteins, and grains. Offer small portions and ensure they can safely self-feed. Avoid choking hazards.";
            default:
                return "Invalid age range.";
        }
    }

    private String getFoodAmountInfo(String age) {
        switch (age) {
            case "6+ years":
                return "For children 6+ years: Offer 3 meals and 2-3 healthy snacks a day. Serve portions that match their hunger and activity level, with an emphasis on balanced meals including protein, carbs, and vegetables.";
            case "From Birth To 6 Months":
                return "For infants from birth to 6 months: Exclusively breastfeed or formula feed. No solid food should be introduced.";
            case "From 6 Months to 12 Months":
                return "For infants from 6 to 12 months: Start with 2-3 small meals per day of pureed foods. Gradually increase the variety and texture of foods.";
            case "From 3–5 years":
                return "For children from 3 to 5 years: Offer 3 meals and 2 snacks per day. Portions should be smaller than adult servings, with a balance of fruits, vegetables, proteins, and grains.";
            case "From 1–3 years":
                return "For toddlers from 1 to 3 years: Offer 3 meals and 2 snacks per day. Keep portion sizes small and ensure a variety of foods.";
            default:
                return "Invalid age range.";
        }
    }

    private String getFoodTimeInfo(String age) {
        switch (age) {
            case "6+ years":
                return "For children aged 6+ years: Meals should be spaced throughout the day, with 3 main meals (breakfast, lunch, dinner) and 2-3 snacks between meals. For sleep, children in this age group typically need 9-11 hours of sleep each night.";
            case "From Birth To 6 Months":
                return "For infants from birth to 6 months: Feed every 2-3 hours with breast milk or formula. No solid food should be introduced at this stage. Newborns typically sleep 14-17 hours a day, including naps.";
            case "From 6 Months to 12 Months":
                return "For infants from 6 to 12 months: Continue breastfeeding/formula feeding 4-6 times per day. Start introducing 2-3 small meals, with a gradual transition to solids. At this age, babies usually need 12-16 hours of sleep per day, including naps.";
            case "From 3–5 years":
                return "For children from 3 to 5 years: 3 meals a day with 2-3 snacks in between. Encourage regular meal times, and avoid eating too close to bedtime. Children in this age group typically need 10-13 hours of sleep each night.";
            case "From 1–3 years":
                return "For toddlers from 1 to 3 years: 3 meals a day and 2 snacks, spaced out to maintain energy and promote healthy growth. Keep meal timing consistent. Toddlers typically need 11-14 hours of sleep, including naps.";
            default:
                return "Invalid age range.";
        }
    }



    private void FillSpinner() {
            // Get Fields Array
            Factory fact = new
                    Factory();
            FieldDataInterface IdI = fact.getModel();
            List<String> fields = IdI.getFields();
            //adapter use to but data inside spinner and list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,fields) ;
        spinner.setAdapter(adapter);
}
    private void ShowList() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSpinner = spinner.getSelectedItem().toString();

                Factory fact1 = new Factory();
                FieldDataInterface fieldDataInterface = fact1.getModel();
                List<Field> fieldsArray = fieldDataInterface.getType(selectedSpinner);
                ArrayList<String> display = new ArrayList<>();

                for (Field field : fieldsArray) {
                    if (field.getName().equalsIgnoreCase(selectedSpinner)) {
                        String str = field.getType();
                        display.add(str);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity4.this, android.R.layout.simple_list_item_1, display);
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Spinner", "No item selected.");
            }
        });
    }}


















