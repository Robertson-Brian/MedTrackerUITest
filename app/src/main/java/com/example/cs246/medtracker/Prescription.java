package com.example.cs246.medtracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;

/**
 * Created by Tim on 2/13/2016.
 */
public class Prescription {

    private int _id;
    private String _prescriptionName;
    private int _quantityMG;
    private float _amountMedication;
    private String _nameMedication;
    private float _amountPerDose;
    private float _dailyMax;
    private Date _refillDate;
    private Date _expirationDate;
    private ArrayList<Dose> _doses;
    private String directions;
    private ArrayList<Observer> prescriptionObservers;


    public Prescription() {

    }

    public Prescription(int id, String prescriptionName, int quantityMG) {
        this._id = id;
        this._prescriptionName = prescriptionName;
        this._quantityMG = quantityMG;
    }

    public Prescription(String prescriptionName, int quantityMG) {
        this._prescriptionName = prescriptionName;
        this._quantityMG = quantityMG;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setPrescriptionName (String prescriptionName) {
        this._prescriptionName = prescriptionName;
    }

    public String getPrescriptionName () {
        return this._prescriptionName;
    }

    public void setQuantityMG (int quantityMG) {
        this._quantityMG = quantityMG;
    }

    public int getQuantityMG () {
        return this._quantityMG;
    }
}
