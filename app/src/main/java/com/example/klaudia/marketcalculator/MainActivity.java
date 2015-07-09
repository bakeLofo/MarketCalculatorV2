package com.example.klaudia.marketcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.klaudia.marketcalculator.Controller.MarketController;
import com.example.klaudia.marketcalculator.Model.Market;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    MyAdapter adapter;
    Context context;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
//        ArrayList<Market> market= new ArrayList<Market>();
//        Market markecik= new Market();
//
//        market.add(0, markecik);
//        markecik.setTitle("cos");
        //Log.d("MainActivity", "title"+markecik.getTitle());
        adapter = new MyAdapter(this, MarketController.getAllMarkets());
       // adapter= new MyAdapter(this,market);
        context = getApplicationContext();


        ListView listview = (ListView) findViewById(R.id.main_list);
        listview.setAdapter(adapter);
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent intent = new Intent(context, Money.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    }


