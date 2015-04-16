package com.example.imrokraft.runtimedb2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 10/4/15.
 */
public class Four extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
    }

    public void deletedetails(View v) {
        EditText t1 = (EditText) findViewById(R.id.editdelete);
        String id = t1.getText().toString();
        databasehandler dbh = new databasehandler(this);
        dbh.delete(id);
        String s = dbh.deleted;
        if (s == "true") {
            Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
            t1.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        }
    }


}
