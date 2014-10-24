package com.example.katievictoriaburke.helloworld; /**
 * Created by katievictoriaburke on 11/10/2014.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeightOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String WEIGHT_TABLE_NAME = "weight_table";
    private static final String KEY_WORD = "weight";
    private static final String KEY_DEFINITION = "date";
    private static final String DATABASE_NAME = "weight_database";

    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + WEIGHT_TABLE_NAME + " (" +
                    KEY_WORD + " TEXT, " +
                    KEY_DEFINITION + " TEXT);";

    WeightOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }


}
