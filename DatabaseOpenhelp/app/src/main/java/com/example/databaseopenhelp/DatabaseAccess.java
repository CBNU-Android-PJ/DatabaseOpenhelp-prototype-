package com.example.databaseopenhelp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    public SQLiteOpenHelper openHelper;
    public SQLiteDatabase db;
    public static DatabaseAccess instance;
    Cursor c = null;

    public DatabaseAccess(Context context) { //데이터 베이스 생성자
        this.openHelper = new DatabaseOpenHelper(context);

    }

    public static DatabaseAccess getInstance(Context context) { // 데이터 베이스 객체 생성 함수
        if (instance == null) {
            instance = new DatabaseAccess(context);

        }
        return instance;
    }

    public void open() {//데이터베이스 읽을 수 있는 권한 부여 함수
        this.db = openHelper.getWritableDatabase();

    }

    public void close() {//데이터 베이스 다 읽고 닫아주는 함수
        if (db != null) {
            this.db.close();
        }
    }

    public String getmenu(String name) { //재료를 name 매개변수로 받으면 query문을 통해 menu를 출력해주는 함수
        c = db.rawQuery("select menu from recipe where ingre1 ='" + name + "'" , new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String menu = c.getString(0);
            buffer.append("" + menu);

        }
        return buffer.toString();
    }
}
