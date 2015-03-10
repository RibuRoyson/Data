package com.example.imrokraft.customizedlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by imrokraft on 10/3/15.
 */
public class AddData extends Activity {
    public static UserModel currentuser;
    EditText nam, emai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit1);
        nam=(EditText)findViewById(R.id.textView3);
        emai=(EditText)findViewById(R.id.textView4);
        if(currentuser!=null)
        {
            nam.setText(currentuser.getName());
            emai.setText(currentuser.getEmail());
        }
        Button save=(Button)findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentuser.setName(nam.getText().toString());
                currentuser.setEmail(emai.getText().toString());
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                AddData.this.finish();
            }
        });
    }


}
