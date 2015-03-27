package com.example.imrokraft.myapps;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imrokraft on 26/3/15.
 */
public  class Register extends Fragment {
EditText nam,add,age,user,pass;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.register,container,false);
        nam=(EditText)root.findViewById(R.id.editname);
        add=(EditText)root.findViewById(R.id.editadd);
        age=(EditText)root.findViewById(R.id.editage);
        user=(EditText)root.findViewById(R.id.username);
        pass=(EditText)root.findViewById(R.id.passText);
        Button a1=(Button)root.findViewById(R.id.button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),"Registered!",Toast.LENGTH_SHORT).show();
                nam.setText("");
                add.setText("");
                age.setText("");
                user.setText("");
                pass.setText("");
            }
        });
        Button b1=(Button)root.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(Register.this.getActivity());
                dialog.setContentView(R.layout.customdialog);
                dialog.setTitle("Exit");
                TextView text=(TextView)dialog.findViewById(R.id.textView);
                text.setText("Are you Sure?");
                ImageView image=(ImageView)dialog.findViewById(R.id.imageView);
                Button yes=(Button)dialog.findViewById(R.id.buttonyes);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Register.this.getActivity().finish();
                        System.exit(0);
                    }
                });
                Button no=(Button)dialog.findViewById(R.id.buttonno);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return  root;
    }



}
