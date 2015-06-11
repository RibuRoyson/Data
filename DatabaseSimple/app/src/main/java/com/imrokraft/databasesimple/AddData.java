package com.imrokraft.databasesimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 4/6/15.
 */
public class AddData extends Activity {
    EditText nam, emai;
    String nam1, qua;
    int id1=-1;
    details d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nam = (EditText) findViewById(R.id.textView3);
        emai = (EditText) findViewById(R.id.textView4);
        Button save = (Button) findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=new details(nam.getText().toString(),emai.getText().toString());
//                currentuser.setName(nam.getText().toString());
//                currentuser.setQual(emai.getText().toString());
                databasehandler dbh = new databasehandler(AddData.this);
                dbh.insert(d);
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                AddData.this.finish();
            }
        });
    }
}
