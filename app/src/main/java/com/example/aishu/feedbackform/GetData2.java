package com.example.aishu.feedbackform;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GetData2 extends AppCompatActivity {

    TextView tv ;
    android.support.v7.widget.Toolbar tool;
    Spinner sp;
    ArrayAdapter<CharSequence> adapter;
    String section,subject,select;
    SQLiteDatabase sdb;
    int sum;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data2);

        tool = findViewById(R.id.toolbar40);
        sp = findViewById(R.id.spinner3);
        tv = findViewById(R.id.answer);

        adapter = ArrayAdapter.createFromResource(this,R.array.details,android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            section = bundle.getString("sec");
            subject = bundle.getString("sub");
            String s = subject+" "+"("+section+")";
            tool.setTitle(s);
        }
        switch (section){

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


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                select = sp.getItemAtPosition(i).toString();
                tv.setText(select);
                //if (select!=null){
                    switch (subject){

                        case "MFCS" :
                           // c = sdb.rawQuery("select * from mfcs",null);
                            //getAvg(select);
                            break;
                        case "FCE" :


                            break;
                        case "EMIII" :


                            break;
                        case "EEE" :


                            break;
                        case "STLD" :


                            break;
                        case "COMPI" :

                            break;
                        case "OOPJ" :


                            break;
                        case "EE Lab" :


                            break;
                        case "COMPI Lab" :


                            break;
                        case "OOPJ Lab" :


                            break;

                    }



                //}

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //
        /*if (select!=null){
        switch (subject){

            case "MFCS" :
                       // detail(select,"mfcs");
               Cursor c = sdb.rawQuery("select "+select+" from mfcs",null);
               if(c!=null){
                    sum = 0;
                    do {
                        c.moveToFirst();
                        int a = c.getColumnIndex(select);
                        String a1 = c.getString(a);
                        int a_1 = Integer.parseInt(a1);
                        sum = sum+a_1;

                    }while (c.moveToNext());
                    String sum1 = sum+"";
                   tv.setText(sum1);
               }


                break;
            case "FCE" :


                break;
            case "EMIII" :


                break;
            case "EEE" :


                break;
            case "STLD" :


                break;
            case "COMPI" :

                break;
            case "OOPJ" :


                break;
            case "EE Lab" :


                break;
            case "COMPI Lab" :


                break;
            case "OOPJ Lab" :


                break;

        }



    }*/
    }



   /* public  void getAvg(String sel){
        sum=0;
        switch(sel){

            case "Interest generated":
                if (c!=null){
                    c.moveToFirst();
                   /*do {

                       int a = c.getInt(c.getColumnIndex("Interest generated"));
                       sum=sum+a;

                   }while (c.moveToNext());*/
                   /*int nrows = c.getCount();
                   for (int i=0;i<nrows;i++){
                       int a = c.getInt(c.getColumnIndex("Interest generated"));
                       sum=sum+a;
                       c.moveToNext();
                   }
                   int average = sum/nrows;
                   tv.setText(average);

                }


                break;

            case "Units covered":

                break;
            case "Regularity and Punctuality":

                break;
            case "Clarity":

                break;
            case "Knowledge":

                break;
            case "Syllabus":

                break;
            case "Ask questions":

                break;
            case "Attitude":

                break;
            case "Class tests":

                break;
            case "Overall opinion":

                break;
            case "Total average":

                break;

        }

    }

   // public void detail(String s,String s1){


     //   int count=0;
       // double c1=0;
        //Cursor c = sdb.rawQuery("select * from "+s1+" where Average=?",null);
        //c.moveToFirst();
        //do {

//            int a = c.getColumnIndex("Average");
  //          String a1 = c.getString(a);
    //        int a_1 = Integer.parseInt(a1);

//            c1=c1+a_1;
  //          count = count + 1;

    //    }while (c.moveToNext());

      //  double average =  c1/count;
        //String average1 = average+"";
       // tv.setText(average1);

    //}*/
}
