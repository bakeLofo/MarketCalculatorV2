package com.example.klaudia.marketcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by klaudia on 07.07.15.
 */
public class Money extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money);

      //  Button button = (Button) findViewById(R.id.submit_amount);
    }

    public void goToBarcode(View v) {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);


    }

}
