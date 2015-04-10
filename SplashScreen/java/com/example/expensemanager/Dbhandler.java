package com.example.expensemanager;

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
    int sum = 0;

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

    public long insertdata(String ai, String bi, String ci, String di, String ei, int fi, int gi, int hi) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense", ai);
        Log.e("exp", ai);
        cv.put("cat", bi);
        Log.e("cat", bi);
        cv.put("description", ci);
        Log.e("dec", ci);
        cv.put("time", di);
        Log.e("tim", di);
        cv.put("date", ei);
        Log.e("dat", ei);
        cv.put("day", fi);
        cv.put("month", gi);
        cv.put("year", hi);

        return db.insert(TB_name, null, cv);
    }

    public Cursor viewdata() {
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from " + TB_name, null);
        return c;
    }

    public ArrayList<String> resultdata() {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            c = db.rawQuery("select * from " + TB_name, null);
            if (c != null) {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        String d = c.getString(c.getColumnIndex("day"));
                        String m = c.getString(c.getColumnIndex("month"));
                        String y = c.getString(c.getColumnIndex("year"));
                        results.add(id + "\t" + exp + "\t\t" + cat + "\t\t" + des + "\t\t" + tim + "\t\t" + dat);


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

    public ArrayList<String> food() {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;

            String[] columns = {"id", "expense", "cat", "description", "time", "date"};
            String selection = "cat=?";
            String[] selectionArgs = {"Food"};
            Log.v("selection", selection);
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null) {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        results.add("Id:" + id + "\nExpense" + exp + "\nDescription:" + des + "\nTime:" + tim + "\nDate:" + dat);
                        if (results.isEmpty() == true) {
                            Toast.makeText(context, "No Records", Toast.LENGTH_SHORT).show();
                        }
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

    public ArrayList<String> Drinks() {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date"};
            String selection = "cat=?";
            String[] selectionArgs = {"Drinks"};
            Log.v("selection", selection);
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null)

            {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        results.add("Id:" + id + "\nExpense" + exp + "\nDescription:" + des + "\nTime:" + tim + "\nDate:" + dat);

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

    public ArrayList<String> Cloth() {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            String[] columns = {"id", "expense", "cat", "description", "time", "date"};
            String selection = "cat=?";
            String[] selectionArgs = {"Dress"};
            Log.v("selection", selection);

            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null)

            {
                if (c.moveToFirst()) ;
                {
                    do {
                        int cc = c.getCount();
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        results.add("Id:" + id + "\nExpense" + exp + "\nDescription:" + des + "\nTime:" + tim + "\nDate:" + dat);
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

    public ArrayList<String> Jan(int x) {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            //int i=x;
            String[] columns = {"id", "expense", "cat", "description", "time", "date", "day", "month", "year"};
            String selection = "month=?";
            String[] selectionArgs = {"x"};
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            if (c != null) {
                if (c.moveToFirst()) ;
                {
                    do {
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        results.add("Id:" + id + "\nExpense" + exp + "\nCategory" + cat + "\nDescription:" + des + "\nTime:" + tim);


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

    public void updateDetails(String expe, String cat, String desc, String tim, String dat, String id1) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expense", expe);
        cv.put("cat", cat);
        cv.put("description", desc);
        cv.put("time", tim);
        cv.put("date", dat);
        String where = "id=?";
        String[] whereArgs = {id1};
        db.update(TB_name, cv, where, whereArgs);
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


    public ArrayList<String> monthWiseData(int x) {
        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor c = null;
            //int i=x;
            String val = String.valueOf(x).toString();

            Log.e("monthvalue", val);
            String[] columns = {"id", "expense", "cat", "description", "time", "date"};
            String selection = "month=?";
            String[] selectionArgs = {val};
            c = db.query(TB_name, columns, selection, selectionArgs, null, null, null);
            Log.e("cursor", "" + c);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        int exp = c.getInt(c.getColumnIndex("expense"));
                        String cat = c.getString(c.getColumnIndex("cat"));
                        String des = c.getString(c.getColumnIndex("description"));
                        String tim = c.getString(c.getColumnIndex("time"));
                        String dat = c.getString(c.getColumnIndex("date"));
                        String id = c.getString(c.getColumnIndex("id"));
                        results.add("Id:" + id + "\nExpense" + exp + "\nCategory" + cat + "\nDescription:" + des + "\nTime:" + tim);
                    } while (c.moveToNext());
                }
            } else {
                Toast.makeText(context, "data no found", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {

        }
        return results;

    }

}
