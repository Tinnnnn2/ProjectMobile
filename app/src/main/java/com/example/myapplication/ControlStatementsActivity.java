package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ControlStatementsActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBackcontrol;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_control_statements);

        btnBackcontrol = findViewById(R.id.btnBackcontrol);
        btnBackcontrol.setOnClickListener(this);

        // หาตัว View main
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } else {
            // แจ้งเตือนถ้า View หาไม่เจอ
            Log.e("ControlStatementsActivity", "View with ID 'main' not found. Check your XML layout.");
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnBackcontrol) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }
}