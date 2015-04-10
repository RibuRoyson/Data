package com.example.expensemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activitymain extends Activity {
    ImageButton add;
    ImageButton show;
    ImageButton edit;
    ImageButton et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void adddatas(View v) {
        Intent aa = new Intent(getApplicationContext(), Add.class);
        startActivity(aa);
    }

    public void editdatas(View v) {
        Intent ac = new Intent(getApplicationContext(), Edit.class);
        startActivity(ac);
    }

    public void viewdatas(View v) {
        Intent ab = new Intent(getApplicationContext(), Show.class);
        startActivity(ab);
    }

    public void exit(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Expense Manager")
                .setMessage("Are you Sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Activitymain.this.finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(getResources().getDrawable(R.drawable.add1))
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

}
