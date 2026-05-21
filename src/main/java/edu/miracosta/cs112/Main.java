package edu.miracosta.cs112;

import edu.miracosta.cs112.models.DietTracker;

public class Main {
    public static void main(String[] args) {
        DietTracker tester = new DietTracker();
        DietTracker copyOfTester = new DietTracker(tester); // DEEP COPY!!
        //edu.miracosta.cs112.models.HealthTracker copyOfTester = tester; //SHALLOW COPY!!

        System.out.println("Start = " + tester);
        System.out.println("Start Copy= " + copyOfTester);

        tester.setWeight(205.6);
        try{
            tester.setHeight(120);
        } catch(UnitMismatchException UME) {
            System.out.println(UME.getMessage());
            System.out.println("If you are seeing this, this test worked!");
        }
        

        System.out.println("After changes = " + tester); //205.6, 100
        System.out.println("After changescopy = " + copyOfTester); //100, 100

        // Test for setWeight method
        // testSetWeight();

        DietTracker myDiet = new DietTracker();
        myDiet.setProtein(0);
        myDiet.setCalories(150);
        myDiet.setToSingleMeal();

        System.out.println("My diet tracker = " + myDiet);
        myDiet.printEncouragingMessage();

        // exception tests
        // error handling for full constructor
        try {
            // edu.miracosta.cs112.models.HealthTracker exceptionTest = new edu.miracosta.cs112.models.HealthTracker(0, 0);
            /*
             * double weight, int height,
             * String foodName, int calories, double protein,
             * boolean isSingleMeal, String goal
             */
            DietTracker exceptionTest = new DietTracker(100, 100,
                    "Cheese", -100, 5.3, false, "snack to avoid eating candy");
            System.out.println("no error for exception test! Here is the object: " + exceptionTest);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage() + ". fix code and run again");
        }

        System.out.println("!!!!reached the end!!");

    }

    // public static void testSetWeight() {
    // edu.miracosta.cs112.models.HealthTracker ht = new edu.miracosta.cs112.models.HealthTracker();
    // double testWeight = 205.6;
    // boolean isValid = ht.setWeight(testWeight);
    // if (isValid) {
    // System.out.println("setWeight test passed: weight set to " + testWeight);
    // } else {
    // System.out.println("setWeight test failed: expected " + testWeight + ", got "
    // + ht.getWeight());
    // }
    // }
}
