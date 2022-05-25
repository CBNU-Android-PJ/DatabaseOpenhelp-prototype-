package com.example.databaseopenhelp;
import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME="data.db";
    private static final int DATABASE_VERSION=1;
    private static final String factory = "" ;

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,  null, DATABASE_VERSION);
    }
}