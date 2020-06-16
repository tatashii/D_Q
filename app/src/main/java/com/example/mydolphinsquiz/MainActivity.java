package com.example.mydolphinsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    public static String EXTRA_NUMBER = "com.example.mydolphinsquiz.example.EXTRA_NUMBER";
    public static String FIRST_NUMBER = "com.example.mydolphinsquiz.example.FIRST_NUMBER";
    public static String SECOND_NUMBER = "com.example.mydolphinsquiz.example.SECOND_NUMBER";
    public static String EXTRA_TEXT = "com.example.mydolphinsquiz.example.EXTRA_TEXT";
    EditText ed1, ed2, ed3, ed4, ed5;
    Button getYourMarks;
    RadioGroup radioGroup;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        getYourMarks = findViewById(R.id.getYourMarks);
        radioGroup = findViewById(R.id.radiogroup);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        cb5 = findViewById(R.id.cb5);

    }


    public void getYourMarks(View view) {

        intent = new Intent(this, QuizeMarks.class);
        //****************************************************************************

            String name = ed1.getText().toString();
            if(name.equals("")){
                Toast.makeText(this, "PLZ enter your Name", Toast.LENGTH_SHORT).show();
            }
            else
            intent.putExtra(EXTRA_TEXT, name);


        //****************************************************************************
        String S_id=ed2.getText().toString();

        if(S_id.equals("")){
            Toast.makeText(this, "PLZ enter your ID", Toast.LENGTH_SHORT).show();

        }
        else{
            int id = Integer.parseInt(S_id);
            intent.putExtra(FIRST_NUMBER, id);
        }

        //****************************************************************************
        String S_Group_No=ed3.getText().toString();
        if(S_Group_No.equals("")){
            Toast.makeText(this, "PLZ enter your Group.No", Toast.LENGTH_SHORT).show();
        }
        else{
            int group_no = Integer.parseInt(S_Group_No);
            intent.putExtra(SECOND_NUMBER, group_no);
        }

        //****************************************************************************
        int totalSumOfMarks = isQ1Correct() + isQ2Correct()
                + isQ3Correct() + didYouPressTheRightCheckBoc();
        intent.putExtra(EXTRA_NUMBER, totalSumOfMarks);
        startActivity(intent);


    }

    public void isChecked(View view) {

        int radioButtonCheckedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonCheckedId);

    }


    private int isQ1Correct() {
        int mark1 = 0;
        String Q1 = ed4.getText().toString();
        if (Q1.equals("")) {
            Toast.makeText(this, "PLZ answer Q1", Toast.LENGTH_SHORT).show();
            return mark1;

        } else {
            int ed4CorrectAnswer = Integer.parseInt(Q1);
            if (ed4CorrectAnswer == 2) {
                mark1 = 100;
                return mark1;

            }
        }
        return mark1;
    }

    private int isQ2Correct() {
         int mark2=0;
        String Q2 = ed5.getText().toString();
        if (Q2.equals("")) {
            Toast.makeText(this, "PLZ answer Q2", Toast.LENGTH_SHORT).show();
            return mark2;

        } else {
            int ed5CorrectAnswer = Integer.parseInt(Q2);
            if (ed5CorrectAnswer == 40) {
                mark2 = 100;
                return mark2;

            }
        }
        return mark2;
    }

    private int isQ3Correct() {

        int radioButtonCheckedId=radioGroup.getCheckedRadioButtonId();

        if(radioButtonCheckedId==1){
            return 100 ;


        } else
            return 0;

    }


    public int didYouPressTheRightCheckBoc() {


        if(cb2.isChecked()==true&&cb4.isChecked()==true&&cb5.isChecked()==true
                && cb1.isChecked()==false&&cb3.isChecked()==false){


            return 100;
        }
        else
            return 0;

    }
















}
