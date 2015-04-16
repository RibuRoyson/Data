package com.example.expensemanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Add extends Activity implements android.view.View.OnClickListener {
    Spinner sp;
    Button tim, dat, save, show;
    EditText time, date, expen, descpt;
    String expense, cat, des, date1, time1, s;
    Dbhandler dbh;
    int dy, mn, yr;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        sp = (Spinner) findViewById(R.id.spinner1);
        tim = (Button) findViewById(R.id.timebtn);
        dat = (Button) findViewById(R.id.datebtn);
        save = (Button) findViewById(R.id.save);
        show = (Button) findViewById(R.id.show);
        time = (EditText) findViewById(R.id.timetxt);
        date = (EditText) findViewById(R.id.datetxt);
        expen = (EditText) findViewById(R.id.exp);
        descpt = (EditText) findViewById(R.id.desc);
        tim.setOnClickListener(this);
        dat.setOnClickListener(this);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        ArrayList<String> val = new ArrayList<String>();
        val.add("Food");
        val.add("Drinks");
        val.add("Dress");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, val);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                cat = sp.getItemAtPosition(arg2).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == dat) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            date.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);
                            dy = dayOfMonth;
                            mn = monthOfYear + 1;
                            yr = year;
                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
        }
        if (v == tim) {

            // Process to get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }
        if (v == save) {
            Log.e("reached", "save");
            expense = expen.getText().toString();
            des = descpt.getText().toString();
            time1 = time.getText().toString();
            date1 = date.getText().toString();
            int id=-1;
            details d = new details(id+"",expense, cat, des,time1,date1,dy,mn,yr);
            d.setExpense(expense);
            d.setCat(cat);
            d.setDescription(des);
            d.setTime1(time1);
            d.setDate1(date1);
            dbh = new Dbhandler(getApplicationContext());
            long g = dbh.insertdata(d);
            if (g > 0) {
                Toast.makeText(Add.this, "Saved", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(Add.this, "Failed", Toast.LENGTH_LONG).show();
            }
            expen.setText("");
            descpt.setText("");
            time.setText("");
            date.setText("");
        }
        if (v == show) {
            Intent inc = new Intent(Add.this, Viewdb.class);
            startActivity(inc);
        }
    }

}
