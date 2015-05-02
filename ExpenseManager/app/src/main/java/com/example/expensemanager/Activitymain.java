package com.example.expensemanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Activitymain extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
    }

    public void adddatas(View v) {
        Intent aa = new Intent(getApplicationContext(), Add.class);
        startActivity(aa);

    }

    public void editdatas(View v) {
        Intent ac = new Intent(getApplicationContext(),Showresult.class);
        startActivity(ac);
    }

    public void viewdatas(View v) {
        Intent in = new Intent(getApplicationContext(), Viewdb.class);
        startActivity(in);
    }

    public void exit(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Expense Manager")
                .setMessage("Are you Sure?")
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Activitymain.this.finish();
                        System.exit(0);
                    }
                })
                .setIcon(getResources().getDrawable(R.drawable.exit))
                .show();

//        final Dialog dialog=new Dialog(Activitymain.this);
//        dialog.setContentView(R.layout.new1);
//        dialog.setTitle("Expense Manager");
//        TextView text=(TextView)dialog.findViewById(R.id.textView);
//        text.setText("Are you sure?");
//        ImageView image=(ImageView)dialog.findViewById(R.id.imageView);
//        image.setImageResource(R.drawable.expense);
//        Button diabutton=(Button)dialog.findViewById(R.id.button2);
//        diabutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Activitymain.this.finish();
//                System.exit(0);
//            }
//        });
//        Button b2=(Button)dialog.findViewById(R.id.button3);
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.cancel();
//            }
//        });
//        dialog.show();
    }
    public void showmonth(View v)
    {
        Intent incc = new Intent(getApplicationContext(), Monthwise.class);
        startActivity(incc);
    }
    public void showcat(View v)
    {
        Intent inc = new Intent(getApplicationContext(), Bycat.class);
        startActivity(inc);
    }
    public void aboutus(View v)
    {
        Intent inccc = new Intent(getApplicationContext(), Aboutus.class);
        startActivity(inccc);
    }

}
