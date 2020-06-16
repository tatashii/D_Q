package com.example.mydolphinsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class QuizeMarks extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize_marks);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        int id = intent.getIntExtra(MainActivity.FIRST_NUMBER, 0);
        int group_no = intent.getIntExtra(MainActivity.SECOND_NUMBER, 0);
        tv1.setText("Student Name : " + name + "\n" + "Student ID : " + id + "\n" + "Student Group.No : " + group_no);
        //********************************************************************************************
        int totalSumOfMarks = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        double TheWholeDegree = 400.0;
        double finalDegree  =  (totalSumOfMarks / TheWholeDegree)*100 ;
        int printDegree=(int) finalDegree;

        tv3.setText(printDegree + " %");

        if(totalSumOfMarks >=(TheWholeDegree/2)){

            String passed="You Passed , congratulations !";
            tv4.setText(passed);
        }
        else {
            String failed = "You Failed , let's do it again";
            tv4.setText(failed);
        }


    }
}
