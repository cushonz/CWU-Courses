// File: ABuggyProgram.java
// Author:
// Last Modified date: 

// required imports
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class ABuggyProgram {

public static String performCalc(int i, double d) {
   return "ttt";
}

    // main method
    public static void main(String[] args) throws IOException {
try {
        // ask what feature should be tested
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Which 'error' would you like to test: ");
        System.out.println(" Press 1 to test FileNotFoundException");
        System.out.println(" Press 2 to test NumberFormatException");
        System.out.println(" Press 3 to test InputMismatchExcpetion");
        int userInput = keyboard.nextInt();

        switch (userInput) {

            case 1:
                // attempt to open a file that doesn't exist
                String fileName = "aFile.txt";
                File aFile = new File(fileName);
                Scanner inputFile = new Scanner(aFile);
                System.out.println("The first line of aFile is: "
                        + inputFile.nextLine());
                break;
            case 2:
                // parsing an integer "String"
                String str = "hey there";
                int intFormOfStr = Integer.parseInt(str);
                break;
            case 3:
                // variables for accessing a file with doubles
                String dataFile = "aDataFile.txt";
                File aDataFile = new File(dataFile);
                Scanner dataInputFile = new Scanner(aDataFile);
                double sumOfDoubleVals = 0.0;
                while (dataInputFile.hasNext()) {
                    sumOfDoubleVals += dataInputFile.nextDouble();
               }
                break;
            default:
                System.out.println("Bad selection. Try again!");
        }
	}
	catch (FileNotFoundException ex) {
	    	System.out.println("File not found");
	    	System.out.println(ex.getMessage());
   } 
	catch (InputMismatchException ex) {
		System.out.println("Mismatch");
		System.out.println(ex.getMessage());
	
  } 
	catch (NumberFormatException ex) {
		System.out.println("Not an integer");
		System.out.println(ex.getMessage());
 }
	   
 }
}