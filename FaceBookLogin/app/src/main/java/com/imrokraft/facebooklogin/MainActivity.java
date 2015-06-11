package com.imrokraft.facebooklogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends ActionBarActivity {
    private static String APP_ID ="494541540710837";
    private LoginButton login;
    private CallbackManager callbackmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        callbackmanager=CallbackManager.Factory.create();
        login=(LoginButton)findViewById(R.id.fb_login_button);
//        login.setReadPermissions("email","userlikes","uer_friends");
//        LoginManager.getInstance().registerCallback(callbackmanager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("public_profile", "user_friends"));
//                Log.e("-->", Arrays.asList("public_profile", "user_friends").toString());
//                Toast.makeText(getApplication(), "success", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancel() {
//                Toast.makeText(getApplication(),"fail",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Toast.makeText(getApplication(),"error",Toast.LENGTH_SHORT).show();
//            }
//        });
        login.registerCallback(callbackmanager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(getApplicationContext(),"Successfull", Toast.LENGTH_SHORT).show();
                String uid=loginResult.getAccessToken().getUserId();
                String auth=loginResult.getAccessToken().getToken();
                Intent in=new Intent(getApplicationContext(),Welcome.class);
                in.putExtra("userid",uid);
                in.putExtra("auth",auth);
                startActivity(in);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Login Attempt Cancel!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"Login Attempt Failed!!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackmanager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
