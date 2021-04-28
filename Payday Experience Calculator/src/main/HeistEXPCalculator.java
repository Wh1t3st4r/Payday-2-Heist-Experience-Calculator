package main;

public class HeistEXPCalculator {
	
	public static double heistCompletion, extraHeistCompletion, lootExperience = 8000, lootCounter, riskBonus;
	public static double playerInCustody, perkDeckBonus, infamyBonus, crewAliveBonus, gagePacks, stealthBonus, repetitiveCompletion;

	public static void eXPFormula() {
		double baseCalculation; 
		if(riskBonus == 0) {
			baseCalculation = (heistCompletion + extraHeistCompletion + (lootExperience * lootCounter));
		} else {
			baseCalculation = (heistCompletion + extraHeistCompletion + (lootExperience * lootCounter)) * riskBonus;
		}
		double firstPercentageCalculation = percentageCalculator(baseCalculation, playerInCustody, false);
		double secondPercentageCalculation = percentageCalculator(firstPercentageCalculation, perkDeckBonus, true);
		double thirdPercentageCalculation = percentageCalculator(secondPercentageCalculation, infamyBonus, true);
		double fourthPercentageCalculation = percentageCalculator(thirdPercentageCalculation, crewAliveBonus, true);
		double fifthPercentageCalculation = percentageCalculator(fourthPercentageCalculation, gagePacks, true);
		double sixthPercentageCalculation = percentageCalculator(fifthPercentageCalculation, stealthBonus, true);
		double seventhPercentageCalculation = percentageCalculator(sixthPercentageCalculation, repetitiveCompletion, false);
		int finalResult = (int)seventhPercentageCalculation;
		System.out.println("Final XP: " + finalResult + "\n---------");
//		System.out.println(firstPercentageCalculation);
//		System.out.println(secondPercentageCalculation);
//		System.out.println(thirdPercentageCalculation);
//		System.out.println(fourthPercentageCalculation);
//		System.out.println(fifthPercentageCalculation);
//		System.out.println(sixthPercentageCalculation);
//		System.out.println(seventhPercentageCalculation);
	}
	
	private static double percentageCalculator(double totalEXP, double percent, boolean penalty) {
		double percentageFinalForm = totalEXP * percent;
		// If the bonus is 0, there will be no consequences, since the calculations are separate, making it a seemless, accurate calculation that does the job.
		if(penalty) {
		double percentageConversionResult = totalEXP + percentageFinalForm;
		return percentageConversionResult;
		}else {
		double percentageConversionResult = totalEXP - percentageFinalForm;
		return percentageConversionResult;
		}
	}
}
