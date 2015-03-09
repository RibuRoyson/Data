package com.example.imrokraft.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, cancel, equal,dot;
    EditText disp;
    float op1;
    float op2;
    String optr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.b1);
        two = (Button) findViewById(R.id.b2);
        three = (Button) findViewById(R.id.b3);
        four = (Button) findViewById(R.id.b4);
        five = (Button) findViewById(R.id.b5);
        six = (Button) findViewById(R.id.b6);
        seven = (Button) findViewById(R.id.b7);
        eight = (Button) findViewById(R.id.b8);
        nine = (Button) findViewById(R.id.b9);
        zero = (Button) findViewById(R.id.b0);
        add = (Button) findViewById(R.id.bplus);
        sub = (Button) findViewById(R.id.bsub);
        mul = (Button) findViewById(R.id.bmul);
        div = (Button) findViewById(R.id.bdiv);
        cancel = (Button) findViewById(R.id.bdel);
        equal = (Button) findViewById(R.id.bequals);
        dot=(Button)findViewById(R.id.bdot);

        disp = (EditText) findViewById(R.id.edittext1);

        try{
            one.setOnClickListener(this);

            two.setOnClickListener(this);

            three.setOnClickListener(this);

            four.setOnClickListener(this);

            five.setOnClickListener(this);

            six.setOnClickListener(this);

            seven.setOnClickListener(this);

            eight.setOnClickListener(this);

            nine.setOnClickListener(this);

            zero.setOnClickListener(this);

            cancel.setOnClickListener(this);

            add.setOnClickListener(this);

            sub.setOnClickListener(this);

            mul.setOnClickListener(this);

            div.setOnClickListener(this);

            equal.setOnClickListener(this);
            dot.setOnClickListener(this);
        }
        catch(Exception e){

        }
    }
    public void operation(){
        if(optr.equals("+")){
            op2 =Float.parseFloat(disp.getText().toString());
            disp.setText("");
            op1 = op1 + op2;
            disp.setText(Float.toString(op1));
        }
        else if(optr.equals("-")){
            op2 = Float.parseFloat(disp.getText().toString());
            disp.setText("");
            op1 = op1 - op2;
            disp.setText(Float.toString(op1));
        }
        else if(optr.equals("*")){
            op2 = Float.parseFloat(disp.getText().toString());
            disp.setText("");
            op1 = op1 * op2;
            disp.setText(Float.toString(op1));
        }
        else if(optr.equals("/")){
            op2 = Float.parseFloat(disp.getText().toString());
            disp.setText("");
            op1 = op1 / op2;
            disp.setText(Float.toString(op1));
        }
    }
    @Override
    public void onClick(View arg0) {
        Editable str =  disp.getText();
        switch(arg0.getId()){
            case R.id.b0:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(zero.getText());
                disp.setText(str);
                break;
            case R.id.b1:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(one.getText());
                disp.setText(str);
                break;
            case R.id.b2:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(two.getText());
                disp.setText(str);
                break;
            case R.id.b3:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(three.getText());
                disp.setText(str);
                break;
            case R.id.b4:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(four.getText());
                disp.setText(str);
                break;
            case R.id.b5:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(five.getText());
                disp.setText(str);
                break;
            case R.id.b6:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(six.getText());
                disp.setText(str);
                break;
            case R.id.b7:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(seven.getText());
                disp.setText(str);
                break;
            case R.id.b8:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(eight.getText());
                disp.setText(str);

                break;
            case R.id.b9:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(nine.getText());
                disp.setText(str);

                break;
            case R.id.bdel:
                op1 = 0;
                op2 = 0;
                disp.setText("");
                Toast.makeText(getApplicationContext(),"cleared!!",Toast.LENGTH_SHORT).show();
                disp.setHint("");

                break;
            case R.id.bplus:
                optr = "+";
                if(op1 == 0){
                    op1 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 + op2;
                    disp.setText(Float.toString(op1));
                }
                break;
            case R.id.bdot:
                if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                str = str.append(dot.getText());
                disp.setText(str);
                break;
            case R.id.bsub:
                optr = "-";
                if(op1 == 0){
                    op1 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 - op2;
                    disp.setText(Float.toString(op1));
                }
                break;
            case R.id.bmul:
                optr = "*";
                if(op1 == 0){
                    op1 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 * op2;
                    disp.setText(Float.toString(op1));
                }
                break;
            case R.id.bdiv:
                optr = "/";
                if(op1 == 0){
                    op1 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                }
                else if(op2 != 0){
                    op2 = 0;
                    disp.setText("");
                }
                else{
                    op2 = Float.parseFloat(disp.getText().toString());
                    disp.setText("");
                    op1 = op1 / op2;
                    disp.setText(Float.toString(op1));
                }
                break;
            case R.id.bequals:
                if(!optr.equals(null)){
                    if(op2 != 0){
                        if(optr.equals("+")){
                            disp.setText("");

                            disp.setText(Float.toString(op1));
                        }
                        else if(optr.equals("-")){
                            disp.setText("");
                            disp.setText(Float.toString(op1));
                        }
                        else if(optr.equals("*")){
                            disp.setText("");
                            disp.setText(Float.toString(op1));
                        }
                        else if(optr.equals("/")){
                            disp.setText("");
                            disp.setText(Float.toString(op1));
                        }
                    }
                    else{
                        operation();
                    }
                }
                break;
        }
    }
}



