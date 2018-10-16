package com.example.aishu.feedbackform;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    Button submit;
    EditText ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10;
    SQLiteDatabase sdb;
    String sec,lec,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,avg1;
    double a_1,a_2,a_3,a_4,a_5,a_6,a_7,a_8,a_9,a_10,avg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //initialize
        toolbar = findViewById(R.id.toolbar2);
        submit = findViewById(R.id.submit);
        ans1 = findViewById(R.id.A1);
        ans2 = findViewById(R.id.A2);
        ans3 = findViewById(R.id.A3);
        ans4 = findViewById(R.id.A4);
        ans5 = findViewById(R.id.A5);
        ans6 = findViewById(R.id.A6);
        ans7 = findViewById(R.id.A7);
        ans8 = findViewById(R.id.A8);
        ans9 = findViewById(R.id.A9);
        ans10 = findViewById(R.id.A10);

        //get extras
       // String sec = getIntent().getExtras().getString("sec");
        //String lec = getIntent().getExtras().getString("Lecturer_name");
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            sec = bundle.getString("sec");
            lec = bundle.getString("Lecturer_name");

        String title = lec+" "+"("+sec+")";

        //set toolbar text
        toolbar.setTitle(title);}





        //create database
        switch (sec){

            case "A":
                sdb = openOrCreateDatabase("Section A",MODE_PRIVATE,null);
                break;
            case "B":
                sdb = openOrCreateDatabase("Section B",MODE_PRIVATE,null);
                break;
            case "C":
                sdb = openOrCreateDatabase("Section C",MODE_PRIVATE,null);
                break;
            case "D":
                sdb = openOrCreateDatabase("Section D",MODE_PRIVATE,null);
                break;
            case "E":
                sdb = openOrCreateDatabase("Section E",MODE_PRIVATE,null);
                break;

        }

        switch (lec){

            case "MFCS" :
                sdb.execSQL("create table if not exists mfcs(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into mfcs values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        intent.putExtra("color","red");
                        startActivity(intent);

                    }
                });

                break;
            case "FCE" :
                sdb.execSQL("create table if not exists fce(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into fce values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "EMIII" :
                sdb.execSQL("create table if not exists em(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into em values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "EEE" :
                sdb.execSQL("create table if not exists eee(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into eee values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "STLD" :
                sdb.execSQL("create table if not exists stld(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";
                        sdb.execSQL("insert into stld values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "COMPI" :
                sdb.execSQL("create table if not exists compi(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into compi values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "OOPJ" :
                sdb.execSQL("create table if not exists oopj(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into oopj values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "EE Lab" :
                sdb.execSQL("create table if not exists eelab(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into eelab values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "COMPI Lab" :
                sdb.execSQL("create table if not exists compilab(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into compilab values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;
            case "OOPJ Lab" :
                sdb.execSQL("create table if not exists oopjlab(Interest varchar(1),Units varchar(1),Punctuality varchar(1),Clarity varchar(1),Knowledge varchar(1),Syllabus varchar(1),Questions varchar(1),Attitude varchar(1),Tests varchar(1),Opinion varchar(1),Average varchar(20))");
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        a1 = ans1.getText().toString();
                        a2 = ans2.getText().toString();
                        a3 = ans3.getText().toString();
                        a4 = ans4.getText().toString();
                        a5 = ans5.getText().toString();
                        a6 = ans6.getText().toString();
                        a7 = ans7.getText().toString();
                        a8 = ans8.getText().toString();
                        a9 = ans9.getText().toString();
                        a10 = ans10.getText().toString();

                        a_1 = Double.parseDouble(a1);
                        a_2 = Double.parseDouble(a2);
                        a_3 = Double.parseDouble(a3);
                        a_4 = Double.parseDouble(a4);
                        a_5 = Double.parseDouble(a5);
                        a_6 = Double.parseDouble(a6);
                        a_7 = Double.parseDouble(a7);
                        a_8 = Double.parseDouble(a8);
                        a_9 = Double.parseDouble(a9);
                        a_10 = Double.parseDouble(a10);

                        avg = (a_1+a_2+a_3+a_4+a_5+a_6+a_7+a_8+a_9+a_10)/10;
                        avg1 = avg+"";

                        sdb.execSQL("insert into oopjlab values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+avg1+"')");

                        Toast.makeText(Form.this,"Submitted",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Form.this,StartPage.class);
                        startActivity(intent);

                    }
                });

                break;

        }

    }
}
