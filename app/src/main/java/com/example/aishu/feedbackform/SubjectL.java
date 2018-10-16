package com.example.aishu.feedbackform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SubjectL extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar ;
    ListView listView;
    Button back;
    ArrayAdapter<String> adapter;
    String sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_l);

        //initialize
        toolbar = findViewById(R.id.toolbar1);
        back = findViewById(R.id.go);
        listView = findViewById(R.id.dynamic);

        //get data from extra
        //sec = getIntent().getExtras().getString("sec");
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
            sec = bundle.getString("sec");
        String s2 = "Section "+sec;

        //set toolbar text
        toolbar.setTitle(s2);}

        //setadapter
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.lecturers));
        listView.setAdapter(adapter);

        //set on click for list view items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               /* Bundle bundle1 = getIntent().getExtras();
                if (bundle1!=null) {
                    String col = bundle1.getString("color");
                    if (col.equals("red"))
                        Toast.makeText(SubjectL.this, "Already selected", Toast.LENGTH_SHORT).show();
                }*/

                //else{
                    Intent intent = new Intent(SubjectL.this, Form.class);
                    intent.putExtra("Lecturer_name", listView.getItemAtPosition(i).toString());
                    intent.putExtra("sec", sec);
                    startActivity(intent);
               // }

            }
        });

        //set go back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1 = new Intent(SubjectL.this,StartPage.class);
                startActivity(i1);

            }
        });

    }
}
