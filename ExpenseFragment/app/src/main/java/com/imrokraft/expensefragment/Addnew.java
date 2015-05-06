package com.imrokraft.expensefragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by imrokraft on 5/5/15.
 */
public class Addnew extends android.support.v4.app.Fragment implements View.OnClickListener {
    Spinner sp;
    Button tim, dat, save, show;
    EditText time, date, expen, descpt;
    String expense, cat, des, date1, time1, s;
    Dbhandler dbh;
    int dy, mn, yr;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.addnew,container,false);
        sp = (Spinner) root.findViewById(R.id.spinner1);
        tim = (Button) root.findViewById(R.id.timebtn);
        dat = (Button) root.findViewById(R.id.datebtn);
        save = (Button) root.findViewById(R.id.save);
        show = (Button) root.findViewById(R.id.show);
        expen = (EditText) root.findViewById(R.id.exp);
        descpt = (EditText) root.findViewById(R.id.desc);
        tim.setOnClickListener(this);
        dat.setOnClickListener(this);
        save.setOnClickListener(this);
        show.setOnClickListener(this);
        ArrayList<String> val = new ArrayList<String>();
        val.add("Food");
        val.add("Drinks");
        val.add("Dress");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, val);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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
        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == dat) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(v.getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            dat.setText(dayOfMonth + "-"
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
            TimePickerDialog tpd = new TimePickerDialog(v.getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            // Display Selected time in textbox
                            tim.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }
        if (v == save) {
            Log.e("reached", "save");
            expense=expen.getText().toString();

            des = descpt.getText().toString();
            time1 = tim.getText().toString();
            date1 = dat.getText().toString();
            int id=-1;
            details d = new details(id+"",expense, cat, des,time1,date1,dy,mn,yr);
            d.setExpense(expense);
            d.setCat(cat);
            d.setDescription(des);
            d.setTime1(time1);
            d.setDate1(date1);
            dbh = new Dbhandler(getActivity().getApplicationContext());
            long g = dbh.insertdata(d);
            if (g > 0) {
                Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
            }
            expen.setText("");
            descpt.setText("");

        }
        if (v == show) {

           getFragmentManager().beginTransaction()
                    .replace(R.id.frame2, new Viewdb())
                    .commit();

        }
    }
}
