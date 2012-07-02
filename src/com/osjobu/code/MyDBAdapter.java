package com.osjobu.code;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 29/06/12
 * Time: 12:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyDBAdapter {

    private static final String TAG = "MyDBAdapter";
    public static final String DATABASE_NAME = "books";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
                    "CREATE TABLE "+ Constants.BOOK_TABLE +" ( "
                    + Constants.BOOK_ID +" integer primary key autoincrement, "
                    + Constants.BOOK_ISBN  +" text not null,"
                    + Constants.BOOK_TITLE +" text not null, "
                    + Constants.BOOK_PUBLISHER+" text not null,"
                    + Constants.BOOK_IMAGE+" text not null );";

    private final Context context;
    private DatabaseHelper DBHelper;

    public MyDBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }

    //---opens the database---
    public MyDBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }


   /*

    //---updates a title---
    public boolean updateTitle(long rowId, String isbn,
                               String title, String publisher)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_ISBN, isbn);
        args.put(KEY_TITLE, title);
        args.put(KEY_PUBLISHER, publisher);
        return db.update(DATABASE_TABLE, args,
                KEY_ROWID + "=" + rowId, null) > 0;
    }      */
}
