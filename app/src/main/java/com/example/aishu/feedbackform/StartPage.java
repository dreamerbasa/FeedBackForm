package com.example.aishu.feedbackform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class StartPage extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    Spinner sp;
    Button retrieve,next;
    ArrayAdapter<CharSequence> adapter;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //initializing the variables
        toolbar = findViewById(R.id.toolbar);
        sp = findViewById(R.id.spinner);
        retrieve = findViewById(R.id.retrieve);
        next = findViewById(R.id.next);

        //set the toolbar text
        toolbar.setTitle(R.string.app_name);

        //create arrayadapter using the string array
        adapter = ArrayAdapter.createFromResource(this,R.array.sections,android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        //get the item selected
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                s = sp.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //set buttons
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (s.equals("----"))
                    Toast.makeText(StartPage.this,"Select a section",Toast.LENGTH_SHORT).show();
                else{

                    Intent i1 = new Intent(StartPage.this,SubjectL.class);
                    i1.putExtra("sec",s);
                    startActivity(i1);

                }

            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (s.equals("----"))
                    Toast.makeText(StartPage.this,"Select a section",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(StartPage.this, GetData.class);
                    intent.putExtra("sec", s);
                    startActivity(intent);
                }

            }
        });

    }
}
