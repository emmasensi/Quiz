package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
/*
This app is music app
the right answers:
south korea
Music
bonn
chinesse and korean
shontel
88
*/

public class MainActivity extends AppCompatActivity {
    EditText q1edittext;
    RadioButton q2radiobutton2;
    RadioButton q3radiobutton;
    CheckBox q4checkbox;
    CheckBox q4checkbox2;
    CheckBox q4checkbox3;
    RadioButton q5radiobutton;
    RadioButton q6radiobutton3;
    RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1edittext = (EditText) findViewById(R.id.q1edittext);
        q2radiobutton2 = (RadioButton) findViewById(R.id.q2radiobutton2_music);
        q3radiobutton = (RadioButton) findViewById(R.id.q3radiobutton_bonn);
        q4checkbox = (CheckBox) findViewById(R.id.q4checkbox_chinese);
        q4checkbox2 = (CheckBox) findViewById(R.id.q4checkbox2_korean);
        q4checkbox3 = (CheckBox) findViewById(R.id.q4checkbox3_japanese);
        q5radiobutton = (RadioButton) findViewById(R.id.q5radiobutton_shontel);
        q6radiobutton3 = (RadioButton) findViewById(R.id.q6radiobutton3_88);
        radio = (RadioGroup) findViewById(R.id.radio);
    }

    public void submit(View view) {
        int score;
        String result;
        score = 0;
        if (checkcheckboxes(q4checkbox, q4checkbox2, q4checkbox3) && radio.getCheckedRadioButtonId() != 0 && q1edittext.getText().toString().isEmpty()) {
            result = "Fill all the questions";
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        } else {
            if (q1edittext.getText().toString().equalsIgnoreCase("south korea")) {
                score++;
            }
            if (q2radiobutton2.isChecked()) {
                score++;
            }
            if (q3radiobutton.isChecked()) {
                score++;
            }
            if (q4checkbox.isChecked() && q4checkbox2.isChecked() && !q4checkbox3.isChecked()) {
                score++;
            }
            if (q5radiobutton.isChecked()) {
                score++;
            }
            if (q6radiobutton3.isChecked()) {
                score++;
            }
            result = "your result is  " + score + "  from  6";
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            if (score > 4) {
                result = "Great gob";
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            } else {
                result = "try again";
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkcheckboxes(CheckBox... checkboxes) {
        for (CheckBox cb : checkboxes) {
            if (cb.isChecked())
                return true;
        }
        return false;
    }
}
