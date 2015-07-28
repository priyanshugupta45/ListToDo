package com.example.himanshu.listtodo;

import android.app.Activity;
import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class fragmentlist extends Fragment {

    Cursor cursor;
    ListView todolist;
    public static final String TAG = "com.example.himanshu.listtodo";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlayout, container, false);
        Log.i(TAG, "fragmentlist oncreate");

        populatelistview();

        todolist = (ListView) view.findViewById(R.id.todolist);

        return view;

    }

    public void populatelistview() {

        Log.i(TAG, "populatelistview1");

        DBHandler dbHandler = new DBHandler(getActivity(),null,null,1);
        Log.i(TAG, "populatelistview2");
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        cursor = dbHandler.getallrows();

        Log.i(TAG, "populatelistview3");
        // Cursor todocursor = db.rawQuery(" SELECT  * FROM LIST_DATABASE", null);
        // Log.i(TAG, "populatelistview4");
        CustomCursorAdapter cursorAdapter = new CustomCursorAdapter(getActivity() ,cursor);
        Log.i(TAG, "populatelistview5");
        todolist.setAdapter(cursorAdapter);
        Log.i(TAG, "populatelistview6");
    }
}