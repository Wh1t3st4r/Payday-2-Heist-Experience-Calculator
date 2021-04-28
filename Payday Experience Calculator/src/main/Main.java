package main;

import java.util.Scanner;

public class Main extends HeistEXPCalculator{
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Select which service you want, \"HEXP\" for the Heist Experience Calculator; or \"EXPC\" for the Experience Calculator");
		String choice = scanner.nextLine();
		if(choice.equalsIgnoreCase("EXPC")) {
			ExperienceCalculator.mainArrangement();
		} else if (choice.equalsIgnoreCase("HEXP")){
			HeistExperienceBase.heistExperienceLoop();
		}
	}
}
