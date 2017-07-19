package com.example.reselbob.myappimapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private List<String> secrets;
    private Iterator<String> iter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        secrets = getSecrets();
        iter = secrets.iterator();
    }

    private List<String> getSecrets() {
        List list = new ArrayList();
        list.add("Be Kind To Strangers");
        list.add("Always Be Honest");
        list.add("The Truth is the Best");
        list.add("Tip Well Always");

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onSecretTap(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        if (!iter.hasNext()) {
            iter = secrets.iterator();
        };
        tv.setText(iter.next());
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
