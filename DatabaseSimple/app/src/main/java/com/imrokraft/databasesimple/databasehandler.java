package com.imrokraft.databasesimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by imrokraft on 4/6/15.
 */
public class databasehandler extends SQLiteOpenHelper {
    private static final String MYDB = "mydb";
    private static final String MYTB = "mytb";
    SQLiteDatabase db;
    Context context;
    public String deleted;
    int id;

    public databasehandler(Context context) {
        super(context, MYDB, null, 32);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + MYTB + "(id integer primary key autoincrement,name text,qualification text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + MYTB);
        onCreate(db);
    }

    public void insert(details d) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", d.getName());
        cv.put("qualification", d.getQual());
        db.insert(MYTB, null, cv);
    }

    public int resultid() {
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + MYTB, null);
            if (c != null) {
                String exp = null;

                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                       id = c.getInt(c.getColumnIndex("id"));



                    } while (c.moveToNext());
                }

                System.out.println(id+"First");

                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return id;
    }

    public ArrayList<details> resultdata() {
        ArrayList<details> results = new ArrayList<details>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + MYTB, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getColumnCount();
                        String Name = c.getString(c.getColumnIndex("name"));
                        String Qualification = c.getString(c.getColumnIndex("qualification"));
                        int id = c.getInt(c.getColumnIndex("id"));
                        results.add(new details(id, Name, Qualification));



                    } while (c.moveToNext());
                }
                c.close();
                db.close();
                System.out.println(id);
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_SHORT).show();
                results.equals(null);
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "Could not connect");

        }
        return results;
    }

    public Cursor update(String i) {
        Cursor c;
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"name", "qualification"};
        String selection = "id=?";
        String[] selectionArgs = {i};
        c = db.query(MYTB, columns, selection, selectionArgs, null, null, null);
        return c;
    }

    public void updateDetails(details d, String id1) {
        if (Integer.parseInt(id1) >= 0)
        {
            db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name", d.getName());
            cv.put("qualification", d.getQual());
            String where = "id=?";
            String[] whereArgs = {id1};

            db.update(MYTB, cv, where, whereArgs);
            db.close();
        }
        else
        {
            insert(d);
        }
    }

    public void delete(String id) {
        Cursor c = null;
        SQLiteDatabase db = getWritableDatabase();
        deleted = "false";
        String[] columns = {"name", "qualification"};
        String selection = "id=?";
        String[] selectionArgs = {id};
        c = db.query(MYTB, columns, selection, selectionArgs, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                String where = "id=?";
                String[] args = {id};
                db.delete(MYTB, where, args);
                deleted = "true";
            } else {
                deleted = "false";
            }
        } else {
            deleted = "fasle";
        }
    }
}
