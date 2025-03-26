package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDataType, btnVariable, btnOperator, btnControlStatements,
            btnFunctions, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        btnDataType = findViewById(R.id.btnDataType);
        btnVariable = findViewById(R.id.btnVariable);
        btnOperator = findViewById(R.id.btnOperator);
        btnControlStatements = findViewById(R.id.btnControlStatements);
        btnFunctions = findViewById(R.id.btnFunctions);
        btnBack = findViewById(R.id.btnBackOperator);

        btnDataType.setOnClickListener(this);
        btnVariable.setOnClickListener(this);
        btnOperator.setOnClickListener(this);
        btnControlStatements.setOnClickListener(this);
        btnFunctions.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnDataType) {
            Intent intent = new Intent(this, DataTypesActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnVariable) {
            Intent intent = new Intent(this, VariablesActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnOperator) {
            Intent intent = new Intent(this, OperatorsActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnControlStatements) {
            Intent intent = new Intent(this, ControlStatementsActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnFunctions) {
            Intent intent = new Intent(this, FunctionsActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnBackOperator) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}