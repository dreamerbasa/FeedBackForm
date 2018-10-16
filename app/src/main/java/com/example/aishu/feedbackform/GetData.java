package com.example.aishu.feedbackform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class GetData extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    Spinner sp;
    Button next;
    ArrayAdapter<CharSequence> adapter;
    String sec;
    String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        toolbar = findViewById(R.id.toolbar45);
        next = findViewById(R.id.button);
        sp = findViewById(R.id.spinner2);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {

            sec = bundle.getString("sec");
            toolbar.setTitle(sec);

        }

        adapter = ArrayAdapter.createFromResource(this,R.array.lecturers,android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                sub = sp.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GetData.this,GetData2.class);
                intent.putExtra("sec",sec);
                intent.putExtra("sub",sub);
                startActivity(intent);

            }
        });

    }
}
