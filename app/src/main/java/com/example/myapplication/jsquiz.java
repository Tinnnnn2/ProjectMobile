package com.example.myapplication;

import android.content.Intent;  // เพิ่ม import นี้
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class jsquiz extends AppCompatActivity {
    private TextView questionText;
    private RadioGroup optionsGroup;
    private Button submitButton;
    private String[][] questions = {
            {"ตัวดำเนินการที่ใช้กำหนดค่าตัวแปรใน JavaScript คืออะไร?", "=", "==", "+=", "===", "0"},
            {"ตัวดำเนินการที่ใช้เปรียบเทียบค่าคืออะไร?", ">", "=", "*", "+", "0"},
            {"ผลลัพธ์ของ 5 + '5' ใน JavaScript คืออะไร?", "10", "55", "Error", "555", "1"},
            {"ตัวดำเนินการที่ใช้สำหรับการบวกสตริงคืออะไร?", "&", "+", "++", "concat()", "1"},
            {"ตัวดำเนินการสามตัวใน JavaScript ใช้ทำอะไร?", "เงื่อนไข", "เปรียบเทียบ", "คำนวณเลข", "สร้างตัวแปร", "0"}
    };
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsquiz);

        questionText = findViewById(R.id.question_text);
        optionsGroup = findViewById(R.id.options_group);
        submitButton = findViewById(R.id.submit_button);

        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionText.setText(questions[currentQuestionIndex][0]);
            for (int i = 0; i < optionsGroup.getChildCount(); i++) {
                ((RadioButton) optionsGroup.getChildAt(i)).setText(questions[currentQuestionIndex][i + 1]);
            }
        } else {
            showResult();
        }
    }

    private void checkAnswer() {
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "เลือกคำตอบก่อน!", Toast.LENGTH_SHORT).show();
            return;
        }

        int correctAnswerIndex = Integer.parseInt(questions[currentQuestionIndex][5]);
        RadioButton selectedRadioButton = findViewById(selectedId);
        int selectedIndex = optionsGroup.indexOfChild(selectedRadioButton);

        if (selectedIndex == correctAnswerIndex) {
            score++;
        }

        currentQuestionIndex++;
        optionsGroup.clearCheck();
        loadQuestion();
    }

    private void showResult() {
        questionText.setText("คุณได้คะแนน " + score + "/" + questions.length);
        optionsGroup.setVisibility(View.GONE);
        submitButton.setText("กลับไปหน้าMENU");

        // เปลี่ยนการทำงานของปุ่ม submit เป็นไปหน้า Menu
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ไปยังหน้า MenuActivity
                Intent intent = new Intent(jsquiz.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void restartQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        optionsGroup.setVisibility(View.VISIBLE);
        submitButton.setText("ส่งคำตอบ");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
        loadQuestion();
    }
}


