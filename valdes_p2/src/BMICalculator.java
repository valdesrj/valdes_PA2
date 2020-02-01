// BMICalculator reads the user's height and weight and calculates and displays
// the user's body mass index. 
// BMICalculator also displays the BMI categories and their values from the 
// National Heart Lung and Blood Institute as follows:
//  Obesity >= 30
//  Overweight = 25 - 29.9
//  Normal weight = 18.5 - 24.9
//  Underweight < 18.5

import java.util.Scanner;

public class BMICalculator {
    // create Scanner for input from Console
	private static Scanner input = new Scanner(System.in);
	
	// declare fields
	private double weight;
	private double height;
	private double bmi; // Body Mass Index
	private String bmiCategory;
	
	public String unitType; // Imperial or Metric
	
	// makes use of both readUnitType and readMeasurementData
	public void readUserData() {
		readUnitType();
		readMeasurementData();
	}
	
	// read the user's option for inputting their measurements as either 
	// Imperial or Metric
	private void readUnitType() {
		boolean done = false;
		do {
		    System.out.print("Please enter the unit type as Imperial (I) or Metric (M): ");
		    unitType = input.next();
		    if (unitType.equalsIgnoreCase("I") || unitType.equalsIgnoreCase("M"))
			    done = true;
		} while (!done);
	}
	
	// call either readMetricData or readImperialData based on the user's choice
	private void readMeasurementData() {
		if (unitType.equalsIgnoreCase("M")) {
			readMetricData();
		}
		if (unitType.equalsIgnoreCase("I")) {
			readImperialData();
		}
	}
	
	// read the user measurement data in Metric units
	private void readMetricData() {
		System.out.print(
				"Please enter your height in centimeters and weight in kilograms: ");
		// convert the height to meters
		setHeight(input.nextDouble() / 100.);
		setWeight(input.nextDouble());
		if (getHeight() < 0 || getWeight() < 0) {
			System.out.println("Error in user input. Exiting application.");
		    System.exit(-1);
		}
	}
	
	// read the user measurement data in Imperial units
	private void readImperialData() {
		System.out.print(
	    		"Please enter your height in inches and weight in pounds: ");
	    setHeight(input.nextDouble());
	    setWeight(input.nextDouble());
	    //System.out.printf("Your height is %.1f and weight is %.1f%n", getHeight(), getWeight());
		if (getHeight() < 0 || getWeight() < 0) {			
			System.out.println("Error in user input. Exiting application.");
			System.exit(-1);
		}
	}
		
	// calculate the user's Body Mass Index (BMI) and BMI Category
	public void calculateBmi() {
		// Imperial units
		if (unitType.equalsIgnoreCase("I")) {
			this.bmi = 703 * getWeight() / (getHeight() * getHeight());
		}
		// Metric units
		else {
			this.bmi = getWeight() / (getHeight() * getHeight());
		}
		
		calculateBmiCategory();
	}
	
	// determine the user's BMI category based on their BMI value
	// reference is the National Heart Lung and Blood Institute
	private void calculateBmiCategory() {
		if (getBmi() >= 30) {
			this.bmiCategory = "Obesity";
		}
		else if (getBmi() >= 25) {
			this.bmiCategory = "Overweight";
		}
		else if (getBmi() >= 18.5) {
			this.bmiCategory = "Normal weight";			
		}
		//  Underweight < 18.5
		else {
			this.bmiCategory = "Underweight";						
		}
	}
	
	// print the BMI value and category to standard output
	// display all the categories and their values so that the user can
	// evaluate his/her BMI
	public void displayBmi() {
		System.out.printf(
				"%nYour BMI value is %.1f and your BMI Category is %s.%n", getBmi(), getBmiCategory());
		System.out.println("\nBelow are the BMI Categories:");
		System.out.println("Underweight < 18.5");
		System.out.println("Normal weight 18.5 - 24.9");
		System.out.println("Overweight 25 - 29.9");
		System.out.println("Obesity 30 or greater");
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}

	public double getBmi() {
		return this.bmi;
	}
	
	public String getBmiCategory() {
		return this.bmiCategory;
	}
}
