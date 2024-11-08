package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private String BabyName;
    private TextView textView;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private CheckBox check4;
    private String Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        BabyName=intent.getStringExtra("ChildName");
        textView=findViewById(R.id.textView4);
        textView.setText(BabyName);
        Age=intent.getStringExtra("Age");
       check1= findViewById(R.id.checkbox1);
         check2=  findViewById(R.id.checkbox2);
        check3= findViewById(R.id.checkbox3);
         check4= findViewById(R.id.checkbox4);

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Check1", "is checked: " + isChecked);
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Check2", "is checked: " + isChecked);
            }
        }); check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Check3", "is checked: " + isChecked);

            }
        });

        check4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Check4", "is checked: " + isChecked);
            }
        });
    }
    public void Continue(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("Age",Age);
        startActivity(intent);
    }
    public void Submit(View view) {
        if(check1.isChecked() && check2.isChecked() && check3.isChecked()){
            Toast.makeText(this,"That Amazing" ,Toast.LENGTH_LONG).show();
        }
        if(!check1.isChecked() && !check2.isChecked() && !check3.isChecked()){
            Toast.makeText(this,"That  is So Bad" ,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Take More Care" ,Toast.LENGTH_LONG).show();
        }
    }
}