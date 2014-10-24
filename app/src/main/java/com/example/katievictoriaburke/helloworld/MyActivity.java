package com.example.katievictoriaburke.helloworld;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.EditText;


public class MyActivity extends Activity {

    EditText weight_text_box;

    public void selfDestruct(View view) {
        int weight = Integer.parseInt(weight_text_box.getText().toString());
        WeightOpenHelper dbHelper = new WeightOpenHelper(getApplicationContext());
        SQLiteDatabase writableDatabase = dbHelper.getWritableDatabase();
        ContentValues weight_date_values = new ContentValues();
        weight_date_values.put("weight", 80);
        weight_date_values.put("date", "909090");
        writableDatabase.beginTransaction();
        writableDatabase.insert("weight_table",null, weight_date_values);
        writableDatabase.endTransaction();
        System.out.println("Data saved");
    }

    public void viewGraph(View view) {
        System.out.println("viewing graph");
        WeightOpenHelper dbHelper = new WeightOpenHelper(getApplicationContext());
        SQLiteDatabase readableDatabase = dbHelper.getReadableDatabase();
        String[] columns = new String[2];
        String[] selectionArgs = new String[0];
        columns[0] = "weight";
        columns[1] = "date";
        readableDatabase.beginTransaction();
        Cursor resultSet = readableDatabase.rawQuery("select * from weight_table", null);
        resultSet.moveToFirst();
        int itemId = resultSet.getInt(0);
        readableDatabase.endTransaction();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        weight_text_box = (EditText) findViewById(R.id.weight_input);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
