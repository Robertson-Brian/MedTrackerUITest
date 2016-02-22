package com.example.cs246.medtracker;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.support.v7.widget.PopupMenu;


public class PrescriptionTest extends AppCompatActivity {

    //private int id;
    //private String prescriptionName;
    //private int quantityMG;

    TextView idView;
    EditText prescriptionBox;
    EditText quantityMGBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_test);

        idView = (TextView) findViewById(R.id.prescriptionID);
        prescriptionBox = (EditText) findViewById(R.id.prescriptionName);
        quantityMGBox = (EditText) findViewById(R.id.quantityMG);
    }

    public void newPrescription (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        int quantityMG = Integer.parseInt(quantityMGBox.getText().toString());

        Prescription prescription = new Prescription(prescriptionBox.getText().toString(), quantityMG);

        dbHandler.addPrescription(prescription);
        prescriptionBox.setText("");
        quantityMGBox.setText("0");
    }

    public void findPrescription (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        Prescription prescription =
                    dbHandler.findPrescription(prescriptionBox.getText().toString());

        if (prescription != null) {
            quantityMGBox.setText(String.valueOf(prescription.getQuantityMG()));
            idView.setText(String.valueOf("ID# " + prescription.getID()));
        } else {
            idView.setText(R.string.no_match);
        }
    }
    public void removePrescription (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        boolean result = dbHandler.deletePrescription(prescriptionBox.getText().toString());

        if (result)
        {
            idView.setText(R.string.record_deleted);
            prescriptionBox.setText("");
            quantityMGBox.setText("0");
        }
        else
            idView.setText(R.string.no_match);
    }


    //created the menu
    //http://www.101apps.co.za/index.php/articles/using-menus-in-your-apps-a-tutorial.html
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
    //*/




}
