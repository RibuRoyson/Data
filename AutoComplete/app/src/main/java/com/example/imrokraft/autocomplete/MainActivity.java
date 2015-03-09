package com.example.imrokraft.autocomplete;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends Activity {
String[] str={"Ribu","Robin","Rahul","Renuka"};
    Button sign;
    CheckBox remember;
    AutoCompleteTextView ACTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ACTV=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        sign=(Button)findViewById(R.id.button);
        remember=(CheckBox)findViewById(R.id.checkBox);
        ArrayAdapter <String> AAD=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,str);
        ACTV.setThreshold(1);
        ACTV.setAdapter(AAD);

    }
public void signin(View v)
{
    Toast.makeText(getApplicationContext(),"Signed in",Toast.LENGTH_SHORT).show();
}


}
