package com.example.imrokraft.runtimedb2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 10/4/15.
 */
public class Third extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
    }
    public void editDetails(View v)
    {
        EditText id1=(EditText)findViewById(R.id.idedit);
        EditText nam=(EditText)findViewById(R.id.nameedit);
        EditText qua=(EditText)findViewById(R.id.quaedit);
        String id=id1.getText().toString();
        databasehandler dbh=new databasehandler(this);
        Cursor c=null;
        c=dbh.update(id);
        if(c!=null)
        {
            if(c.moveToFirst())
            {
                String s=c.getString(c.getColumnIndex("name"));
                String q=c.getString(c.getColumnIndex("qualification"));
                nam.setText(s);
                qua.setText(q);
                c.close();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_SHORT).show();
        }
    }
    public void updatedata(View v)
    {
        String name1,qual1,id1;
        EditText id=(EditText)findViewById(R.id.idedit);
        EditText nam=(EditText)findViewById(R.id.nameedit);
        EditText qua=(EditText)findViewById(R.id.quaedit);
        databasehandler dbh=new databasehandler(this);
        name1=nam.getText().toString();
        qual1=qua.getText().toString();
        id1=id.getText().toString();
        details d=new details();
        d.setName(name1);
        d.setQual(qual1);
        dbh.updateDetails(d, id1);
        Toast.makeText(getApplicationContext(),"Details Updated",Toast.LENGTH_SHORT).show();
    }
    public void viewdata(View v)
    {
        Intent inc=new Intent(getApplicationContext(),Second.class);
        startActivity(inc);
    }
}
