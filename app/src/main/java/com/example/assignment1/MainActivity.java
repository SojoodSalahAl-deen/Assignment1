package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText enterEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       enterEditText= findViewById(R.id.enter_edit_txt);

    }

    public void Continue(View view) {
        String childName= enterEditText.getText().toString();

        Intent intent= new Intent(this, MainActivity2.class);
        intent.putExtra("ChildName",childName);
        startActivity(intent);


    }
}