package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Nivedita Kokil', 'nskokil@gmail.com','7584','7834831238', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Kani Pandey', 'kpandey@gmail.com','1258','8995258438', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Sunil Chad', 'surya@gmail.com','8896','7595422996', 1060)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Mahendra Garasiya', 'magarasiya12@gmail.com','7752','9268949038', 8790 )");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Labeen Mishra', 'labeen23@gmail.com','3669','9069548962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Piya Joshi', 'piyaj2@gmail.com','9985','8739140238', 14988)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Rachel Krishnan ', 'rachelgreen@gmail.com','1207','8624140215', 9999)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Nilam Shere', 'neelam@gmail.com','4522','9776221539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Ritik Shah', 'ritik@gmail.com','6582','9344335238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Ahuja', 'rohit.ahuja@gmail.com','5450','8396191231', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Dhruv Sharma', 'dhruv5691@gmail.com','2656','83195641200', 12800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Seema joshi', 'joshiseema@gmail.com','1203','8993641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Meera Sehgal', 'meera812@gmail.com','5566','9133541001', 13800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Vihaan Parashar', 'vihaanp6@gmail.com','2236','6944342205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Aditya Kulkarni', 'kulkarniaditya@gmail.com','6692','7786641266', 16500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}