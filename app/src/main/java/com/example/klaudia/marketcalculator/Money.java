package com.example.klaudia.marketcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


/**
 * Created by klaudia on 07.07.15.
 */
public class Money extends Activity {
    String money;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money);
       edit = (EditText) findViewById(R.id.spend);


      //  Button button = (Button) findViewById(R.id.submit_amount);
    }

    public void goToBarcode(View v) {
        Intent intent = new Intent(this, ProductListActivity.class);
        money= String.valueOf(edit.getText());
        intent.putExtra("amount",money);
        Log.d("Money", "amount" + money);
        startActivity(intent);


    }

}
