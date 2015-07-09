package com.example.klaudia.marketcalculator.Controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.klaudia.marketcalculator.Model.Market;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Acer on 8.7.2015.
 */
public class ImportData {


    InputStream is=null;
    String cont = null;
    String line=null;
    String result=null;
    String name;
    Context context;
    String incorrect;
    JSONArray jsonArray;

    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    private class TheTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

//        @Override
//        protected void onPostExecute(JSONArray result) {
//            // might want to change "executed" for the returned string passed
//            // into onPostExecute() but that is upto you
////            jsonArray = result;
//        }

        @Override
        protected JSONArray doInBackground(String... params) {
            ReadDatabase rb = new ReadDatabase();
            JSONArray json = rb.getJSONFromUrl(params[0]);
            jsonArray  = json;
            return json;
        }

    }

    public JSONArray getJson(){
        TheTask task = new TheTask();
        try {
            jsonArray = task.execute("http://genti.bildhosting.me/bildAndroid/ReadAllMarkets.php").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  jsonArray;
    }

    public List<Market> downloadMarkets(){
        List<Market> markets = new ArrayList<>();

        JSONArray json = getJson(); //changit
        for (int i=0; i<json.length(); i++){
            try {
                JSONObject obj = json.getJSONObject(i);



                Market market = new Market();
                market.setId(obj.getInt("0"));
                market.setTitle(obj.getString("1"));
                market.setLocation(obj.getString("2"));
                Log.i("market", market.getTitle());

                markets.add(market);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return markets;
    }

}
