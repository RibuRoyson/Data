package com.example.imrokraft.runtimedb2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 13/4/15.
 */
public class AddData extends Activity {
    EditText nam, emai;
    String nam1,qua;
    int id1;
    details d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        nam=(EditText)findViewById(R.id.textView3);
        emai=(EditText)findViewById(R.id.textView4);
        Intent i=getIntent();
        id1=i.getExtras().getInt("id");
        nam1=i.getExtras().getString("name");
        qua=i.getExtras().getString("qual");
        emai.setText(qua);
        nam.setText(nam1);

        d=new details(id1,nam1,qua);
//
//        if(currentuser!=null)
//        {
//            nam.setText(currentuser.getName());
//            emai.setText(currentuser.getQual());
//        }
        Button save=(Button)findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setName(nam.getText().toString());
                d.setQual(emai.getText().toString());

//                currentuser.setName(nam.getText().toString());
//                currentuser.setQual(emai.getText().toString());
                databasehandler dbh=new databasehandler(AddData.this);


                dbh.updateDetails(d,id1+"");
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                AddData.this.finish();
            }
        });
    }


}
