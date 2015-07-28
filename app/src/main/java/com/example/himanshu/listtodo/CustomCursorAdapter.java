package com.example.himanshu.listtodo;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter{

    public static final String TAG = "com.example.himanshu.listtodo";
    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c);
        Log.i(TAG,"CustomCursorAdapter");
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // when the view will be created for first time,
        // we need to tell the adapters, how each item will look
        Log.i(TAG , "newView");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.list, parent, false);



        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView todotext = (TextView) view.findViewById(R.id.todotext);
        todotext.setText(cursor.getString(cursor.getColumnIndexOrThrow("todoitem")));

    }
}
