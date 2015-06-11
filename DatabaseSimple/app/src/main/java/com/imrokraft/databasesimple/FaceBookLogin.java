package com.imrokraft.databasesimple;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by imrokraft on 5/6/15.
 */
public class FaceBookLogin extends ActionBarActivity {
    private static String APP_ID ="494541540710837";
    private LoginButton login;
    private CallbackManager callbackmanager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.facebook);
        callbackmanager=CallbackManager.Factory.create();
        login=(LoginButton)findViewById(R.id.login_button);

        login.registerCallback(callbackmanager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(getApplicationContext(),"User ID:"+loginResult.getAccessToken().getUserId(),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Auth Token:"+loginResult.getAccessToken().getToken(),Toast.LENGTH_LONG).show();
//                    new async().execute("");
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Login Attempt Cancel!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(),"Login Attempt Failed!!",Toast.LENGTH_SHORT).show();
            }
        });
        login.setReadPermissions(Arrays.asList("basic_info","email"));


    }
public class async extends AsyncTask<String,Void,String>
{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... params) {
        List<String> permissions=new ArrayList<String>();
        permissions.add("email");

        return null;
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackmanager.onActivityResult(requestCode,resultCode,data);
    }

}