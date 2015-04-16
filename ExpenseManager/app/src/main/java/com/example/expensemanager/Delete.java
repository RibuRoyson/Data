package com.example.expensemanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends Activity {
    EditText dele;
    Button a;
    Dbhandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        dele = (EditText) findViewById(R.id.del);
        a = (Button) findViewById(R.id.deleted);
        a.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String idd = dele.getText().toString();
                Dbhandler dbh = new Dbhandler(Delete.this);
                dbh.deletedetails(idd);
                String s = dbh.deleted;
                if (s == "true") {
                    Toast.makeText(Delete.this, "Data Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Delete.this, "No data found", Toast.LENGTH_LONG).show();
                }
                dele.setText("");
            }
        });
    }


}
