package main;

import java.util.Scanner;

public class ExperienceCalculator {
	
	/*
	 * This part of the program was originaly developed by Nikolas Beltran (aka. nikolasb), studied and interpreted by me.
	 * 
	 */
	
	private static int[] levels = {900, 1250, 1550, 1850, 2200, 2600, 3000, 3500, 4000, 4600, 4601, 4611, 4637, 4687, 4771, 4895, 5068, 5299, 5595, 5965, 6417, 6959, 7600, 8347, 9208, 10193, 11308, 12563, 13965, 15523, 17245, 19139, 21213, 23476, 25935, 28599, 31476, 34574, 37902, 41467, 45278, 49342, 53670, 58267, 63143, 68306, 73763, 79524, 85596, 91988, 98707, 105762, 113161, 120913, 129025, 137506, 146363, 155606, 165242, 175279, 185726, 196591, 207881, 219606, 231774, 244392, 257468, 271012, 285031, 299533, 314527, 330021, 346022, 362540, 379582, 397156, 415271, 433936, 453157, 472943, 493303, 514245, 535776, 557906, 580642, 603992, 627965, 652569, 677811, 703701, 730247, 757456, 785336, 813897, 843146, 873091, 903741, 935104, 967187, 1000000};
    private static int totalExperience = 23336413;

	public static void mainArrangement() {
		Scanner scanner = new Scanner(System.in);
		int loop = 0;
		while(loop == 0) {
			System.out.println("Enter the number of your desired level to be calculated, or type \"exit\" to close this");
			if(scanner.hasNextInt()) {
				int inputtedLevel = scanner.nextInt();
				if(inputtedLevel >=0 && inputtedLevel <=100) {
					requiredExperienceCalculator(inputtedLevel);
				} else {
					System.out.println("Enter the level from \"0\" to \"100\"!");
				}
				
			} else if(scanner.next().equalsIgnoreCase("exit")) {
				System.out.println("Alrighty, have a good one!");
				loop = 1;
			}
		}
		scanner.close();
	}
	
	private static void requiredExperienceCalculator(int level) {
		int requiredExperience = 0;
		for(int i = level; i < levels.length; i++) {
			requiredExperience += levels[i];
		}
		System.out.println("Required XP: " + requiredExperience + "\nYour completion percentage is: " + experiencePercentage(totalExperience - requiredExperience) + "%\n");
	}
	
	private static float experiencePercentage(int currentExperience) {
		return ((float)currentExperience/totalExperience) * 100;
	}
}
