package com.imrokraft.expensefragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 5/5/15.
 */
public class EditData extends Fragment implements View.OnClickListener {
    EditText exp, cat, desc, tim, dat;
    String id, cat1, desc1, tim1, dat1, exp1;
    details d;
    int a, b, c;
    Dbhandler dbh;
    Button updat, dele, vieb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.new1, container, false);
        exp = (EditText) root.findViewById(R.id.expet);
        cat = (EditText) root.findViewById(R.id.catet);
        desc = (EditText) root.findViewById(R.id.deset);
        tim = (EditText) root.findViewById(R.id.timeet);
        dat = (EditText) root.findViewById(R.id.dateet);
        updat = (Button) root.findViewById(R.id.updatbtn);
        dele = (Button) root.findViewById(R.id.deletebtn);
        vieb = (Button) root.findViewById(R.id.viewbtn);
        updat.setOnClickListener(this);
        dele.setOnClickListener(this);
        vieb.setOnClickListener(this);
        if((((MainActivity)getActivity()).b!=null))
        {
            id = ((MainActivity)getActivity()).b.getString("id");
            exp1 = ((MainActivity)getActivity()).b.getString("expense");
            cat1 = ((MainActivity)getActivity()).b.getString("cat");
            desc1 =((MainActivity)getActivity()).b.getString("description");
            tim1 = ((MainActivity)getActivity()).b.getString("time");
            dat1 = ((MainActivity)getActivity()).b.getString("date");
            exp.setText(exp1);
            cat.setText(cat1);
            desc.setText(desc1);
            tim.setText(tim1);
            dat.setText(dat1);
            d = new details(id, exp1, cat1, desc1, tim1, dat1, a, b, c);
        }
        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == updat) {
            d.setExpense(exp.getText().toString());
            d.setCat(cat.getText().toString());
            d.setDescription(desc.getText().toString());
            d.setTime1(tim.getText().toString());
            d.setDate1(dat.getText().toString());
            dbh = new Dbhandler(getActivity().getApplicationContext());
            dbh.updateDetails(d, id + "");
            exp.setText("");
            cat.setText("");
            desc.setText("");
            tim.setText("");
            dat.setText("");
            Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

        }
        if (v == dele) {
            new AlertDialog.Builder(v.getContext())
                    .setTitle("Expense Manager")
                    .setMessage("Are you sure?")
                    .setPositiveButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbh = new Dbhandler(getActivity().getApplicationContext());
                            String nm = String.valueOf(Integer.parseInt(String.valueOf(id)));
                            dbh.deletedetails(nm);
                            Toast.makeText(getActivity().getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                            exp.setText("");
                            cat.setText("");
                            desc.setText("");
                            tim.setText("");
                            dat.setText("");
                        }
                    })
                    .show();

        }
        if (v == vieb) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.frame2, new Viewdb())
                    .commit();
        }
    }
}
