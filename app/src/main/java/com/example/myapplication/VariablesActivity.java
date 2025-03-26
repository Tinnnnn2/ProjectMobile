package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class VariablesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBackVariable, btn ;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables);

        // ตั้งค่า Toolbar
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // ปุ่มย้อนกลับ
        btnBackVariable = findViewById(R.id.btnBackVariable);
        btnBackVariable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBackVariable) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            //finish(); // ปิด Activity ปัจจุบัน
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_variable, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.menu_identifier) {
//            showToast("ตัวระบุ JavaScript");
//        } else if (id == R.id.menu_assignment) {
//            showToast("ผู้ดำเนินการมอบหมาย");
//        } else if (id == R.id.menu_datatype) {
//            showToast("ประเภทข้อมูล JavaScript");
//        } else if (id == R.id.menu_variable_declare) {
//            showToast("การประกาศตัวแปร JavaScript");
//        } else if (id == R.id.menu_multiple_var) {
//            showToast("หนึ่งคำสั่ง หลายตัวแปร");
//        } else if (id == R.id.menu_undefined) {
//            showToast("ค่า = ไม่ได้กำหนด");
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//        return true;
//    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
