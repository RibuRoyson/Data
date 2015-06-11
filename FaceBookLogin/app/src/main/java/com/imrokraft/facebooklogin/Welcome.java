package com.imrokraft.facebooklogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by imrokraft on 11/6/15.
 */
public class Welcome extends ActionBarActivity {
   TextView userid,authen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        userid=(TextView)findViewById(R.id.editText);
        authen=(TextView)findViewById(R.id.editText2);
        Intent in=getIntent();
        String s1=in.getExtras().getString("userid");
        String s2=in.getExtras().getString("auth");
        userid.setText(s1);
        authen.setText(s2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.logout:
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
