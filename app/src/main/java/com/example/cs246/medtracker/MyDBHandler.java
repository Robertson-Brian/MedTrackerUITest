package com.example.cs246.medtracker;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

/**
 * MyDBHandler
 * Used to form appropriate SQL strings in order to build and
 * manipulate a SQLite Database without having to submit
 * queries by hand.
 * Created by Tim on 2/13/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "prescriptionDB.db";
    private static final String TABLE_PRESCRIPTIONS = "prescriptions";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRESCRIPTIONNAME = "prescriptionName";
    public static final String COLUMN_QUANTITYMG = "quantityMG";

    /**
     * MyDBHandler()
     * Builds a DBHandler object when provided with the required
     * parameters
     * @param context: Context object
     * @param name: Blank String to satisfy Override reqs
     * @param factory: CursorFactory object
     * @param version Blank Int to satisfy Override reqs
     */
    public MyDBHandler (Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRESCRIPTIONS_TABLE = "CREATE TABLE " +
                TABLE_PRESCRIPTIONS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRESCRIPTIONNAME
                + " TEXT," + COLUMN_QUANTITYMG + " INTEGER" + ")";
        db.execSQL(CREATE_PRESCRIPTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS " + TABLE_PRESCRIPTIONS);
        onCreate(db);
    }

    public void addPrescription(Prescription prescription) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRESCRIPTIONNAME, prescription.getPrescriptionName());
        values.put(COLUMN_QUANTITYMG, prescription.getQuantityMG());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PRESCRIPTIONS, null, values);
        db.close();
    }

    public Prescription findPrescription(String prescriptionName) {
        String query = "Select * FROM " + TABLE_PRESCRIPTIONS + " WHERE " + COLUMN_PRESCRIPTIONNAME + " =  \"" + prescriptionName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Prescription prescription = new Prescription();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            prescription.setID(Integer.parseInt(cursor.getString(0)));
            prescription.setPrescriptionName(cursor.getString(1));
            prescription.setQuantityMG(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        } else {
            prescription = null;
        }
        db.close();
        return prescription;
    }

    public boolean deletePrescription(String prescriptionName) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PRESCRIPTIONS + " WHERE " + COLUMN_PRESCRIPTIONNAME + " =  \"" + prescriptionName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Prescription prescription = new Prescription();

        if (cursor.moveToFirst()) {
            prescription.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRESCRIPTIONS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(prescription.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
