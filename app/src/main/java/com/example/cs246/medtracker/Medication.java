package com.example.cs246.medtracker;

/**
 * Medication Class - Used for tracking a specific
 * medication a user will be taking
 */
public class Medication {
    private String name;
    private String unitType;

    public Medication(String name, String unitType)
    {
        this.name = name;
        this.unitType = unitType;
    }
    public String getUnitType()
    {
        return this.unitType;
    }

    public String getMedicationName()
    {
        return this.name;
    }
}
