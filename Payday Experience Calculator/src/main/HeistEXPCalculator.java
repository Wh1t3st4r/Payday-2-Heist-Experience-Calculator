package main;

import java.math.BigDecimal;

public class HeistEXPCalculator {
	
	public static int baseHeistCompletion, extraHeistCompletion, lootExperience = 8000, lootCounter;
	public static BigDecimal baseCalculation, riskBonus = new BigDecimal(0), additiveBonuses = new BigDecimal(0), playerInCustody, perkDeckBonus = new BigDecimal(0), infamyBonus, crewAliveBonus, gagePacks, stealthBonus, repetitiveCompletion;

	public static void eXPFormula() {
		baseCalculation = new BigDecimal(baseHeistCompletion + extraHeistCompletion + (lootExperience * lootCounter));
		if(riskBonus.doubleValue() != 0.0) {
			baseCalculation = baseCalculation.multiply(riskBonus);
			if(Main.debug == true) System.out.println("BaseCalculation: " + baseCalculation );		
		}
		int[] percentageCalculation = new int[5];
		percentageCalculation[0] = percentageCalculator(baseCalculation, playerInCustody, false);
		percentageCalculation[1] = percentageCalculator(baseCalculation, perkDeckBonus, true);
		percentageCalculation[2] = percentageCalculator(baseCalculation, infamyBonus, true);
		percentageCalculation[3] = percentageCalculator(baseCalculation, crewAliveBonus, true);
		percentageCalculation[4] = percentageCalculator(baseCalculation, gagePacks, true);
		for(int i = 0; i < percentageCalculation.length; i++) {
			additiveBonuses = additiveBonuses.add(new BigDecimal(percentageCalculation[i]));
			if(Main.debug == true) System.out.println("Additive Bonus " + i + " " + percentageCalculation[i] + ": " + additiveBonuses);
		}
		BigDecimal finalExp = baseCalculation.add(additiveBonuses);
		if(stealthBonus.doubleValue() != 0.0)
			finalExp = finalExp.add(new BigDecimal(percentageCalculator(finalExp, stealthBonus, true)));
		if(repetitiveCompletion.doubleValue() != 0.0) {
			if(Main.debug == true) System.out.println("Executed repetitiveCompletion math: " + finalExp);
			finalExp = finalExp.add(new BigDecimal(percentageCalculator(finalExp, repetitiveCompletion, false)));
//			bonus = false'' already triggers a subtract method, applying it here broke everything, apparently math signal game is
//			applicable to methods of java.Math, probably with every other value manipulation with negative numbers
			
		} // Fix these code lines above, subtracting is adding millions to the end result
		System.out.println("Final XP: "  + finalExp + "\n---------");
	}
	
	private static int percentageCalculator(BigDecimal totalEXP, BigDecimal percent, boolean bonus) {
		BigDecimal percentageFinalForm = totalEXP.multiply(percent);
		// If the bonus is 0, there will be no consequences, since the calculations are separate, making it a seemless, accurate calculation that does the job.
		if(bonus) {
			if(percent.doubleValue() == 0.0) //Returning int will break all decimals, dumbass!
				return 0;
			else {
				BigDecimal percentageConversionResult = percentageFinalForm.add(totalEXP);
				percentageConversionResult.intValue();
				return percentageConversionResult.intValue();
			}
		}else {
			if(percent.doubleValue() == 0.0)
				return 0;
			else {
				BigDecimal percentageConversionResult = percentageFinalForm.subtract(totalEXP); // Returns negative outcome
				return percentageConversionResult.intValue();
			}
		}
	}
}
