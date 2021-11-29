package main;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class HeistEXPCalculator {
	
	public static int baseHeistCompletion, extraHeistCompletion, lootExperience = 8000, lootCounter;
	public static BigDecimal baseCalculation, riskBonus = new BigDecimal(0), additiveBonuses = new BigDecimal(0), playerInCustody, perkDeckBonus = new BigDecimal(0), infamyBonus, crewAliveBonus, gagePacks, stealthBonus, repetitiveCompletion;
	
	public static void eXPFormula() {
		baseCalculation = new BigDecimal(baseHeistCompletion + extraHeistCompletion + (lootExperience * lootCounter));
		if(riskBonus.doubleValue() != 0.0) {
			baseCalculation = baseCalculation.multiply(riskBonus);
			baseCalculation = baseCalculation.add(new BigDecimal(percentageCalculator(baseCalculation, playerInCustody, false)));
			if(Main.debug == true) System.out.println("BaseCalculation: " + baseCalculation );		
		}
		int[] percentageCalculation = new int[4];
		percentageCalculation[0] = percentageCalculator(baseCalculation, perkDeckBonus, true);
		percentageCalculation[1] = percentageCalculator(baseCalculation, infamyBonus, true);
		percentageCalculation[2] = percentageCalculator(baseCalculation, crewAliveBonus, true);
		percentageCalculation[3] = percentageCalculator(baseCalculation, gagePacks, true);
		for(int i = 0; i < percentageCalculation.length; i++) {
			additiveBonuses = additiveBonuses.add(new BigDecimal(percentageCalculation[i]));
			if(Main.debug == true) System.out.println("Additive Bonus NO" + i + "Value: " + percentageCalculation[i] + "Final: " + additiveBonuses);
		}
		BigDecimal finalExp = baseCalculation.add(additiveBonuses);
		if(stealthBonus.doubleValue() != 0.0)
			finalExp = finalExp.add(new BigDecimal(percentageCalculator(finalExp, stealthBonus, true)));
		if(repetitiveCompletion.doubleValue() != 0.0) {
			if(Main.debug == true) System.out.println("Executed repetitiveCompletion math: " + finalExp);
			finalExp = finalExp.add(new BigDecimal(percentageCalculator(finalExp, repetitiveCompletion, false)));
		}
		JOptionPane.showMessageDialog(null, "Final EXP: " + finalExp, "Final EXP Value", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("---------\nFinal XP: "  + finalExp);
		/*
		Clean-up
		 */
		additiveBonuses = BigDecimal.ZERO;
		finalExp = BigDecimal.ZERO;
	}
	
	private static int percentageCalculator(BigDecimal totalEXP, BigDecimal percent, boolean bonus) {
		if(bonus) {
			if(percent.doubleValue() == 0.0) 
				return 0;
			else {
				return totalEXP.multiply(percent).intValue();
			}
		} else {
			if(percent.doubleValue() == 0.0)
				return 0;
			else {
				return totalEXP.multiply(percent.multiply(new BigDecimal(-1))).intValue();
			}
		}
	}
}
