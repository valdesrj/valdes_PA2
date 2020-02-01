import java.util.Scanner;

/* BMI Categories:
 * 
 * Obese >= 30
 * Overweight >= 25
 * Normal weight >= 18.5
 * Under weight < 18.5
 * 
 * 
 * */


public class BMICalculator {
	
	private static Scanner input = new Scanner(System.in);
	
	private double weight;
	private double height;
	public String unitType;
	
	
	private void readUnitType() {
		boolean done = false;
		do {
		    System.out.print("Please enter the unit type as Imperial (I) or Metric (M): ");
		    unitType = input.next();
		    if (unitType.equalsIgnoreCase("I") || unitType.equalsIgnoreCase("M"))
			    done = true;
		} while (!done);
		
	}
	
	private void readMeasurementData() {
		// Calls either readMetricData of readImperialData
		// depending on the unit type.
		if (unitType.equalsIgnoreCase("M")) {
			readMetricData();
		}
		if (unitType.equalsIgnoreCase("I")) {
			readImperialData();
		}
		
	}
	
	private void readMetricData() {
		System.out.println("Metric Data");
	}
	
	private void readImperialData() {
		System.out.println("Imperial Data");
	}
	
	public void readUserData() {
		// Makes use of both readUnitType and readMeasurementData.
		readUnitType();
		readMeasurementData();
		
	}
	
	public void calculateBmi() {
		// Calculate the user's BMI and BMI category.
		
	}
	
	public void calculateBmiCategory() {
		// Determine the user's BMI category.
		
		
	}
	
	public void displayBmi() {
		// Print the BMI value and category to standard output.
		// Also display all the categories and their values so that the user 
		// can evaluate his/her BMI.
		
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	

}
