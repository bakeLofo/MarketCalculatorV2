package com.example.klaudia.marketcalculator.Controller;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadDatabase {

    static InputStream iStream = null;
    static JSONArray jarray = null;
    static String json = "";


    public ReadDatabase() {
    }

    public JSONArray getJSONFromUrl(String url) {
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        try {
            HttpResponse response = client.execute(httppost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e("==>", "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jo = null;
        JSONObject j = null;
        try{
            jo = new JSONObject(builder.toString());
            j = jo.getJSONObject("market");
            Iterator x = j.keys();
            jarray = new JSONArray();
            while (x.hasNext()){
                String key = (String) x.next();
                jarray.put(j.get(key));
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return jarray;
    } // Parse String to JSON object try { jarray = new JSONArray( builder.toString()); } catch (JSONException e) { Log.e("JSON Parser", "Error parsing data " + e.toString()); } // return JSON Object return jarray; }


}
