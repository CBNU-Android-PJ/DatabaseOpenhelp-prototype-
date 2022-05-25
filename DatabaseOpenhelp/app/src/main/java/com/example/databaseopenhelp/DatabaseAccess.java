package com.example.databaseopenhelp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
   public SQLiteOpenHelper openHelper;
   public SQLiteDatabase db;
   public static DatabaseAccess instance;
   Cursor c=null;
public DatabaseAccess(Context context){
    this.openHelper=new DatabaseOpenHelper(context);

}
public static DatabaseAccess getInstance(Context context){
    if(instance==null){
        instance=new DatabaseAccess(context);

    }
    return instance;
}
public void open(){
    this.db=openHelper.getWritableDatabase();

}
public void close(){
    if(db!=null){
        this.db.close();
    }
}
public String getAddress(String name){
    c=db.rawQuery("select Address from Table1 where Name ='"+name+"'",new String[]{});
    StringBuffer buffer= new StringBuffer();
    while(c.moveToNext()){
        String address=c.getString(0);
        buffer.append(""+address);

    }
    return buffer.toString();
}
}
