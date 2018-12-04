package com.example.abir.langtesttwo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private int mSelected = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvHelloWorld = (TextView) findViewById(R.id.tv_hello) ;

        tvHelloWorld.setText(getResources().getString(R.string.hello_world));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Tools.langChangeAction(MainActivity.this);
//                showLangDialog();
            }
        });
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


    public void showLangDialog() {

        Dialog dialog;
        final String[] items = {" PHP", " JAVA", " JSON", " C#", " Objective-C"};
        final boolean[] items2 = {true, false, false, false, false};
        final ArrayList itemsSelected = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select Languages you know : ");
        builder.setMultiChoiceItems(items, items2,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedItemId,
                                        boolean isSelected) {
//                        if (isSelected) {
//                            itemsSelected.add(selectedItemId);
//                        } else if (itemsSelected.contains(selectedItemId)) {
//                            itemsSelected.remove(Integer.valueOf(selectedItemId));
//                        }
                        final AlertDialog alert = (AlertDialog) dialog;
                        final ListView list = alert.getListView();
                        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

                        if (isSelected) {
                            if ((mSelected != -1) && (mSelected != selectedItemId)) {
                                final int oldVal = mSelected;
                                list.setItemChecked(oldVal, false);

                            }
                            mSelected = selectedItemId;
                        } else {

//                            final int oldVal1 = mSelected;
//                            mSelected = -1;
//                            list.setItemChecked(oldVal1, true);
//                            mSelected = selectedItemId;
                            mSelected = -1;


                        }
                    }

                })
                .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Your logic when OK button is clicked
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        dialog = builder.create();
        dialog.show();


    }
}
