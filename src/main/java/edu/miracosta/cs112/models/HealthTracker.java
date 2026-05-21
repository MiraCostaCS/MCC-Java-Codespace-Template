package edu.miracosta.cs112.models;

import edu.miracosta.cs112.UnitMismatchException;

/**
 * CLASS INVARIANT
 * - height must be in total inches
 */
public abstract class HealthTracker {
    // constants
    public static final double DEFAULT_WEIGHT = 100;
    public static final int DEFAULT_HEIGHT = 100;

    // instance vars
    private double weight;
    private int height; // in inches
    private boolean heightOverride;

    // constructors
    public HealthTracker(double weight, int height) {
        boolean isValid;
        try{
            isValid = this.setWeight(weight) && this.setHeight(height);
        } catch(UnitMismatchException UME) {
            System.out.println(UME.getMessage());
            isValid = false;
        }
        
        if (!isValid) {
            // throw error (checking)
            throw new IllegalArgumentException("ERROR: bad data given to edu.miracosta.cs112.models.HealthTracker full constructor");
        }
    }

    public HealthTracker() {
        this(DEFAULT_WEIGHT, DEFAULT_HEIGHT);
    }

    public HealthTracker(HealthTracker original) {
        if (original == null) {
            // throw error (checking)
            throw new IllegalArgumentException("ERROR: null given to edu.miracosta.cs112.models.HealthTracker copy constructor");
        }
        this.weight = original.weight;
        this.height = original.height;
    }

    // mutators
    public boolean setWeight(double weight) {
        //Implementing the UnitMismatch exception here would be a lot more difficult
        //Since weight varies a lot more, and kilograms and lbs are closer than cm and inches
        if (weight > 0) { //only set if valid data
            this.weight = weight;
            return true;
        } else {
            return false;
        }
    }

    public boolean setHeight(int height) throws UnitMismatchException{
        if (height > 0 && height < 108) { // only set if valid data
            this.height = height;
            return true;
        } else if (!heightOverride) {
            // in other countries people measure height in cm and that frequently goes above 100,
            // heights in inches almost never, this catches most (but not all cases) where someone uses cm.
            throw new UnitMismatchException("Inches");
        } else {
            return false;
        }
    }

    public boolean setHeight(int feet, int inches) {
        int totalInches = feet * 12 + inches;
        // this is tough because the UnitMismatch Exception is implemented in the inches setter
        // will only ever cause problems if someone is under ~3'7" or the tallest person in history.
        // decided to put in an override just in case of these cases, could be handled in main method or gui
        // either way not something that is easily handled specifically here as it requires user input
        // left it as a boolean in this class though, and added a method to enable it.
        // in order to not be insensitive the prompt could be something like: 
        // "based on your input it appears you may be using centimeters while we expected inches, would you like to try again or continue with these measurements?"
        // then a simple try again or a continue. 
        try{
            return setHeight(totalInches);
        } catch(UnitMismatchException UME){
            System.out.println(UME.getMessage());
            return false;
        }
    }

    public void overrideHeight() {
        // Enables that override I was talking about
        heightOverride = true;
    }

    // accessors
    public double getWeight() {
        return this.weight;
    }

    public int getHeightInInches() {
        return this.height;
    }

    /**
     * Get height in string form (feet and inches)
     * 
     * @return string with feet and inches form
     */
    public String getHeight() {
        int feet = this.height / 12;
        int inches = this.height % 12;
        return feet + " ft " + inches + " in";
    }


    // other required methods
    @Override
    public String toString() {
        return "Weight = " + this.weight +
                ", Height = " + this.height;
    }

    @Override
    public boolean equals(Object other) {
        // null
        if (other == null) {
            return false;
        } else if (!(other instanceof HealthTracker)) {// "same" type
            // different type
            return false;

        } else {
            // exists AND "same type"
            // check all the data
            HealthTracker otherTracker = (HealthTracker) other;
            return this.height == otherTracker.height && this.weight == otherTracker.weight;
        }

    }

    public abstract void printEncouragingMessage();
}