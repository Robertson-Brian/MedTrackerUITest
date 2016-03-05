package com.example.cs246.medtracker;

import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.InputEvent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.*;

public class CalTest extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button CalTestButton = (Button) findViewById(R.id.CalTestButton);
        CalTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ////////////////////////////////code

                Calendar cal = new GregorianCalendar();              
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, 2);
                long time = cal.getTime().getTime();
                Uri.Builder builder =
                        CalendarContract.CONTENT_URI.buildUpon();
                builder.appendPath("time");
                builder.appendPath(Long.toString(time));
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, builder.build());
                startActivity(intent);

/*
                Intent intent =
                        new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                startActivity(intent);
*/
/*
                long startMillis = System.currentTimeMillis();
                Uri.Builder builder2 = CalendarContract.CONTENT_URI.buildUpon();
                builder2.appendPath("time");
                ContentUris.appendId(builder2, startMillis);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(builder2.build());
                startActivity(intent);
*/


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        switch (item.getItemId()) {
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CalTest Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.cs246.medtracker/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CalTest Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.cs246.medtracker/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
