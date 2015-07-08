package com.example.klaudia.marketcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {

    MyAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"Solaris Ulci", "Roda", "Maxi"};
        adapter = new MyAdapter(this, names);
         context = getApplicationContext();


        ListView listview = (ListView) findViewById(R.id.main_list);
        listview.setAdapter(adapter);
       // listview.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);


       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Log.d("MainActivity", "balkshd");
                Intent intent = new Intent(context, Money.class);
                startActivity(intent);
                    Log.d("bla", "blas");

            }
        });
    }
         /*   @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Money.class);
                startActivity(intent);
            }
        });*/




    }


