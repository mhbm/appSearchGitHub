package com.example.android.appsearchgithub.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lsitec101.macedo on 21/05/18.
 */

public class RepoDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";

    private static final int DATABASE_VERSION = 1;

    public RepoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_MOVIES_TABLE = "CREATE TABLE " + RepoContract.RepoEntry.TABLE_NAME + " (" +
                RepoContract.RepoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RepoContract.RepoEntry.COLUMN_NAMEAUTHOR + " TEXT NOT NULL, " +
                RepoContract.RepoEntry.COLUMN_NAMEREPO + " TEXT NOT NULL, " +
                RepoContract.RepoEntry.COLUMN_NAMEAUTHOR + " TEXT NOT NULL, " +
                RepoContract.RepoEntry.COLUMN_NUMBERFORK + " TEXT NOT NULL, " +
                RepoContract.RepoEntry.COLUMN_NUMBERSTAR + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_MOVIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RepoContract.RepoEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
