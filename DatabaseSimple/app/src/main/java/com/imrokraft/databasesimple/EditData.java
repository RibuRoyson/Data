package com.imrokraft.databasesimple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by imrokraft on 4/6/15.
 */
public class EditData extends Activity {
    EditText nam, emai;
    String nam1, qua,obj,s1,s2;
    int id1=-1;
    details d;
    final ParseObject database=new ParseObject("SimpleDB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nam = (EditText) findViewById(R.id.textView3);
        emai = (EditText) findViewById(R.id.textView4);
        Intent i = getIntent();
        id1 = i.getExtras().getInt("id");
        nam1 = i.getExtras().getString("name");
        qua = i.getExtras().getString("qual");
        obj= getIntent().getExtras().getString("objectid").trim();
        System.out.println("objectid:" + obj);
        emai.setText(qua);
        nam.setText(nam1);
        s1=nam.getText().toString();
        s2=emai.getText().toString();
        d = new details(id1, nam1, qua);
        Button save = (Button) findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setName(nam.getText().toString());
                d.setQual(emai.getText().toString());
//                currentuser.setName(nam.getText().toString());
//                currentuser.setQual(emai.getText().toString());
                databasehandler dbh = new databasehandler(EditData.this);
                dbh.updateDetails(d, id1 + "");
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("SimpleDB");
                query.getInBackground(obj, new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject database, com.parse.ParseException e) {
                        if (e == null) {
                            database.put("Name",nam.getText().toString());
                            database.put("Qualification", emai.getText().toString());
                            database.saveInBackground();
                        }
                    }
                });
            }
        });
    }
    public void del(View v)
    {
        databasehandler dbh = new databasehandler(EditData.this);

        String nm= String.valueOf(Integer.parseInt(String.valueOf(id1)));
        dbh.delete(nm);
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), obj, Toast.LENGTH_SHORT).show();
        ParseObject.createWithoutData("SimpleDB",obj).deleteEventually();
        EditData.this.finish();
    }


}

