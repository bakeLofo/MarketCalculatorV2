package com.example.klaudia.marketcalculator.data_base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Julian on 09/07/2015.
 */
public class DatabaseHandler_Article extends SQLiteOpenHelper {
    public static final String ARTICLE_KEY = "id";
    public static final String ARTICLE_TITLE = "title";
    public static final String ARTICLE_PRICE = "price";
    public static final String ARTICLE_MARKET_ID = "market_id";

   public static final String ARTICLE_TABLE_NAME = "Article";
    public static final String ARTICLE_TABLE_CREATE =


          "  CREATE TABLE" + ARTICLE_TABLE_NAME + "(" + ARTICLE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ ARTICLE_TITLE + "TEXT,"+ARTICLE_PRICE + " REAL" + ARTICLE_MARKET_ID + " INT);";

    public DatabaseHandler_Article(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){ super(context, name, factory, version);}
@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL(ARTICLE_TABLE_CREATE);
}




    public static final String ARTICLE_TABLE_DROP = "DROP TABLE IF EXISTS" + ARTICLE_TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(ARTICLE_TABLE_DROP);
        onCreate(db);
    }
}
