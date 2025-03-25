package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataTypesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBackDataType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_types);

        btnBackDataType = findViewById(R.id.btnBackDataType);

        btnBackDataType.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.btnBackDataType) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    }
}