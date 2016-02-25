package com.example.cs246.medtracker;

import java.util.Date;

/*
 * Created by Tim on 2/23/2016.
 */
public class Dose {
    private Medication medication;
    private float amountDose;
    private String directions;
    private Date doseDate;

    public void scheduleDose(Date doseDateToadd)
    {
        this.doseDate = doseDateToadd;
    }
}
