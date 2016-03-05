package com.example.cs246.medtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Alerts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        //inflate the menu; this adds items to the action
        //bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);
        String title = "Menu List";
        int groupID = Menu.NONE;
        int itemId = Menu.FIRST;
        int order = 103;
        menu.add(groupID, itemId, order, title);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.context_ScripTest:
                Intent item1 = new Intent(this, PrescriptionTest.class);
                this.startActivity(item1);
                break;
            case R.id.context_login:
                Intent item2 = new Intent(this, EmptyLogin.class);
                this.startActivity(item2);
                break;
            case R.id.context_Alerts:
                Intent item3 = new Intent(this, Alerts.class);
                this.startActivity(item3);
                break;
            case R.id.context_calTest:
                Intent item4 = new Intent(this, CalTest.class);
                this.startActivity(item4);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
