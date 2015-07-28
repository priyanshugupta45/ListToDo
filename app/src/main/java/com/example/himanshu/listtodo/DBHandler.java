package com.example.himanshu.listtodo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Listtodo.db";
    public static final String LIST_DATABASE = "Listtable";
    public static final String COLUMN_ID = "_sno";
    public static final String COLUMN_TODO = "todoitem";
    public static final String TAG = "com.example.himanshu.listtodo";;


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE  TABLE " + LIST_DATABASE + "( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + COLUMN_TODO + " TEXT " + " ); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXITS " + LIST_DATABASE);
        onCreate(db);

    }

    //adding rows to the table

    public void addtolist(listitems listitem) {

        Log.i(TAG,"addtodata");
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO, listitem.getTodoitem());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(LIST_DATABASE, null, values);
        db.close();
    }

    //deleting rows from table

    public void deletefromlist(String todo) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + LIST_DATABASE + " WHERE " + COLUMN_TODO + " =\"" + todo + "\";");

    }



    //get all rows

    public Cursor getallrows() {

        //String dbsting = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + LIST_DATABASE + " WHERE 1";

        //cursor points to the location in your result
        Cursor c = db.rawQuery(query, null);

        //move to the first row in your result
        c.moveToFirst();
  /*     while (!c.isAfterLast()) {

            if (c.getString(c.getColumnIndex("todoitem")) != null) {
                dbsting = c.getString(c.getColumnIndex("todoitem"));
                dbsting += "\n";

                Log.i("TAG", "I am here: " + dbsting);
            }

            c.moveToNext();

       }
        db.close(); */
        return c;

    }
}


