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

public class OperatorsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBackOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operators);

        btnBackOperator = findViewById(R.id.btnBackOperator);
        btnBackOperator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnBackOperator) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}