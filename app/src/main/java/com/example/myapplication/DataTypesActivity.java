package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DataTypesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBackDataType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_types);

        btnBackDataType = findViewById(R.id.btnBackDataTypes);


        btnBackDataType.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnBackDataTypes) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}
