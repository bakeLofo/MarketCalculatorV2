package com.example.klaudia.marketcalculator.data_base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Julian on 09/07/2015.
 */
public class DatabaseHandler_Market extends SQLiteOpenHelper {
    public static final String MARKET_KEY = "id";
    public static final String MARKET_TITLE = "title";
    public static final String MARKET_LOCATION = "location";

    public static final String MARKET_TABLE_NAME = "Market";
    public static final String MARKET_TABLE_CREATE = "CREATE TABLE " + MARKET_TABLE_NAME + "("+ MARKET_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT,"+MARKET_TITLE + "TEXT,"+ MARKET_LOCATION + "TEXT);";

    public DatabaseHandler_Market(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(MARKET_TABLE_CREATE);

    }
    public static final String MARKET_TABLE_DROP = "DROP TABLE IF EXISTS"+ MARKET_TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(MARKET_TABLE_DROP);
        onCreate(db);
    }
}
