package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity2 extends AppCompatActivity {
    private TextView showTxtView;
    private RadioGroup radioGroup;
    private String BabyName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        showTxtView=findViewById(R.id.textView);
        radioGroup=findViewById(R.id.radiGroup);
        Intent intent= getIntent();
         BabyName= intent.getStringExtra("ChildName") + " Baby";
        showTxtView.setText(BabyName);
        //First Radio Button
       RadioButton radioButton= findViewById(R.id.radioButton);
       radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               Log.d("RADIO1", "Pirates is checked: " + isChecked);


           }
           //This comment for my will the Studying .
           //Radio Button is subclass From Compound Button.
           // Compound button is Button that have states checked or unChecked such as Radio Button , CheckBox and so on
       });
     //Second Radio Button
        RadioButton radioButton2= findViewById(R.id.radioButton2);
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("RADIO2", "Radio2: " + isChecked);


            }
        });
        //Third Radio Button
        RadioButton radioButton3= findViewById(R.id.radioButton3);
        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("RADIO3", "Radio3: " + isChecked);


            }
        });
        //Fourth Radio Button
        RadioButton radioButton4= findViewById(R.id.radioButton4);
        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("RADIO4", "Radio4: " + isChecked);


            }
        });
        //Fifth Radio Button
        RadioButton radioButton5= findViewById(R.id.radioButton5);
        radioButton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("RADIO5", "Radio5: " + isChecked);


            }
        });
        }
    public void Continue(View view){
        //if one of the radio button is checked Contiune Elase Apper messageng To Toast

        RadioGroup radioGroup = findViewById(R.id.radiGroup);
        int Id=radioGroup.getCheckedRadioButtonId();
        if(Id == -1){
            Toast.makeText(this,"No Selected Age",Toast.LENGTH_LONG).show();
            //There is No selected Radio Button
        }
        else{
            RadioButton radioButton= findViewById(Id);
            String str =radioButton.getText().toString();
            Intent intent= new Intent(this, MainActivity3.class);
            intent.putExtra("Age",str);
            intent.putExtra("ChildName",BabyName);
            startActivity(intent);
        }
    }

        }






