package edu.miracosta.cs112;

public class UnitMismatchException extends Exception{
    public UnitMismatchException(){
        super("Error:Possible wrong unit type given to setter/constructor. Please reference the proper type of unit requested and try again.");
    }

    public UnitMismatchException(String expected){
        super("Error:Possible wrong unit type givent to setter/constructor (expected type: " + expected + ") Please try again");
    }
}

