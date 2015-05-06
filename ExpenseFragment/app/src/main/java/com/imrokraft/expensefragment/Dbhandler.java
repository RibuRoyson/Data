package com.imrokraft.expensefragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Dbhandler extends SQLiteOpenHelper {
    public static final String DB_name = "expensedb";
    public static final String TB_name = "myexp";
    public String deleted;
    SQLiteDatabase db;
    Context context;


    public Dbhandler(Context context) {
        super(context, DB_name, null, 32);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table if not exists " + TB_name + "(id integer primary key autoincrement,expense integer,cat text,description text,time text,date text,day integer,month integer,year integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("drop table if exists " + TB_name);
        onCreate(db);
    }

    public long insertdata(details d) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense", d.getExpense());
        cv.put("cat", d.getCat());
        cv.put("description", d.getDescription());
        cv.put("time", d.getTime1());
        cv.put("date", d.getDate1());
        cv.put("day", d.getDy());
        cv.put("month", d.getMn());
        cv.put("year", d.getYr());
        return db.insert(TB_name, null, cv);
    }

    public ArrayList<details> resultdata() {
        ArrayList<details> results = new ArrayList<details>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int cc = c.getCount();
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();
            }
        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return results;
    }

    public int total() {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            Cursor d;
            Log.e("TOTAL", "reached");
            d = db.rawQuery("select expense from " + TB_name, null);

            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int x = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + x;

                    }
                    while (d.moveToNext());
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }

    public int totalmnth() {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            int y = 0;
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            y = mMonth + 1;
            String val = String.valueOf(y).toString();
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);

            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int x = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + x;

                    }
                    while (d.moveToNext());
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }

    public Cursor update(String i) {
        Cursor c;
        db = this.getWritableDatabase();
        String[] columns = {"expense", "cat", "description", "time", "date"};
        String selection = "id=?";
        String[] selectionArgs = {i};
        c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
        return c;
    }

    public void updateDetails(details d, String id1) {
        if (Integer.parseInt(id1) >= 0) {
            db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("expense", d.getExpense());
            cv.put("cat", d.getCat());
            cv.put("description", d.getDescription());
            cv.put("time", d.getTime1());
            cv.put("date", d.getDate1());
            String where = "id=?";
            String[] whereArgs = {id1};
            db.update(TB_name, cv, where, whereArgs);
        } else {
            insertdata(d);
        }
    }

    public void deletedetails(String idd) {
        Cursor c = null;
        SQLiteDatabase db = getWritableDatabase();
        deleted = "false";
        String[] columns = {"expense", "cat", "description", "time", "date"};
        String selection = "id=?";
        String[] selectionArgs = {idd};
        c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                String where = "id=?";
                String[] args = {idd};
                db.delete(TB_name, where, args);
                deleted = "true";
            } else {
                deleted = "false";
            }


        } else {
            deleted = "false";
        }
    }

    public ArrayList<details> category(String ca) {
        ArrayList<details> results = new ArrayList<details>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "cat=?";
            String[] selectionArgs = {ca};
            Log.v("selection", selection);

            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null)

            {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        if (cc < 1) {
                            return null;
                        }
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
                c.close();
                db.close();
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return results;
    }

    public ArrayList<details> monthWiseData(int x) {
        ArrayList<details> results = new ArrayList<details>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;

            String val = String.valueOf(x).toString();
            Log.e("monthvalue", val);
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            Log.e("cursor", "" + c);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String exp = c.getString(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        int d = c.getInt(c.getColumnIndex("day"));
                        int m = c.getInt(c.getColumnIndex("month"));
                        int y = c.getInt(c.getColumnIndex("year"));
                        results.add(new details(id, exp, cat, des, tim, dat, d, m, y));
                    } while (c.moveToNext());
                }
            } else {
                Toast.makeText(context, "data no found", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

        }
        return results;

    }

    public int monthtotal(int a) {
        int exp = 0;
        db = this.getReadableDatabase();
        try {
            String val = String.valueOf(a).toString();
            Cursor d = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            Log.v("selection", selection);

            d = db.query(TB_name, columns, selection, selectionArgs, null, null, null);

            if (d != null) {
                if (d.moveToFirst()) ;
                {
                    do {
                        int cc = d.getCount();
                        if (cc < 1) {
                           return 0;
                        }
                        int z = d.getInt(d.getColumnIndex("expense"));
                        exp = exp + z;

                    }
                    while (d.moveToNext());
                }
            } else {
                Toast.makeText(context, "Results Empty", Toast.LENGTH_LONG).show();

            }

        } catch (SQLiteException se) {
            Log.e(getClass().getSimpleName(), "could not connect");
        }
        return exp;

    }

}
