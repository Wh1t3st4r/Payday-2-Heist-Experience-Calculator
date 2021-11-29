package main;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class HeistExperienceBase extends HeistEXPCalculator {
	
	public static void heistExperienceLoop() {
		infoGatherPrompt();
		eXPFormula();
		while(JOptionPane.showConfirmDialog(null, "Do you wish to repeat the calculation?") == 0) {
			infoGatherPrompt();
			eXPFormula();
		}
	}
	
	private static void infoGatherPrompt(){
		
		String[] riskBonusInput = {"Normal (0x)", "Hard (2x)", "Very Hard (5x)", "Overkill (10x)", "Mayhem (11.5x)", "Death Wish (13x)", "Death Sentence (14x)"};
		boolean playerInCustodyBool;
		
		System.out.println(lootCounter = Integer.parseInt(JOptionPane.showInputDialog("How many bags of Meth will be delivered?")));
		
		switch(JOptionPane.showInputDialog(null, "Choose the Difficulty of the Heist: ", "Risk Bonus Multiplication", JOptionPane.PLAIN_MESSAGE, null, riskBonusInput, null).toString()) {
		case "Normal (0x)": 
			Main.riskBonus = new BigDecimal(0);
		break;
		case "Hard (2x)":
			Main.riskBonus = new BigDecimal(2.0);
		break;
		case "Very Hard (5x)":
			Main.riskBonus = new BigDecimal(5.0);
		break;
		case "Overkill (10x)":
			Main.riskBonus = new BigDecimal(10.0);
		break;
		case "Mayhem (11.5x)":
			Main.riskBonus = new BigDecimal(11.5);
		break;
		case "Death Wish (13x)":
			Main.riskBonus = new BigDecimal(13.0);
		break;
		case "Death Sentence (14x)":
			Main.riskBonus = new BigDecimal(14.0);
		break;				
		}
		
		if(JOptionPane.showConfirmDialog(null, "Will the heist have any players in custody?", "Players in Custody at the end of the heist", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0) {
			Main.playerInCustody = new BigDecimal(0.3);
			playerInCustodyBool = true;
		}else {
			Main.playerInCustody = new BigDecimal(0);
			playerInCustodyBool = false;
		}
		
		if(JOptionPane.showConfirmDialog(null, "Do you have the \"Blending In\" perk bonus in your current Perk Deck?", "Perk Deck Upgrade Skill", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0) {
			Main.perkDeckBonus = new BigDecimal(0.3);
		}else {
			Main.perkDeckBonus = new BigDecimal(0);
		}
		
		String[] infamyBonusInput = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
		
		switch(JOptionPane.showInputDialog(null, "What is your Infamy level? Select \"0\" if you don't have any Infamy Level", "Infamy Level (0 - 25) Gives bonuses", JOptionPane.QUESTION_MESSAGE, null, infamyBonusInput, null).toString()) {
		case "1":
			Main.infamyBonus = new BigDecimal(0.05);
		break;
		case "2":
			Main.infamyBonus = new BigDecimal(0.15);
		break;
		case "3":
			Main.infamyBonus = new BigDecimal(0.20);
		break;
		case "4":
			Main.infamyBonus = new BigDecimal(0.30);
		break;
		case "5":
			Main.infamyBonus = new BigDecimal(0.35);
		break;
		case "6":
			Main.infamyBonus = new BigDecimal(0.45);
		break;
		case "7":
			Main.infamyBonus = new BigDecimal(0.50);
		break;
		case "8":
			Main.infamyBonus = new BigDecimal(0.60);
		break;
		case "9":
			Main.infamyBonus = new BigDecimal(0.65);
		break;
		case "10":
			Main.infamyBonus = new BigDecimal(0.75);
		break;
		case "11":
			Main.infamyBonus = new BigDecimal(0.825);
		break;
		case "12":
			Main.infamyBonus = new BigDecimal(0.925);
		break;
		case "13":
			Main.infamyBonus = new BigDecimal(1.0);
		break;
		case "14":
			Main.infamyBonus = new BigDecimal(1.10);
		break;
		case "15":
			Main.infamyBonus = new BigDecimal(1.175);
		break;
		case "16":
			Main.infamyBonus = new BigDecimal(1.275);
		break;
		case "17":
			Main.infamyBonus = new BigDecimal(1.350);
		break;
		case "18":
			Main.infamyBonus = new BigDecimal(1.450);
		break;
		case "19":
			Main.infamyBonus = new BigDecimal(1.525);
		break;
		case "20":
			Main.infamyBonus = new BigDecimal(1.625);
		break;
		case "21":
			Main.infamyBonus = new BigDecimal(1.700);
		break;
		case "22":
			Main.infamyBonus = new BigDecimal(1.800);
		break;
		case "23":
			Main.infamyBonus = new BigDecimal(1.875);
		break;
		case "24":
			Main.infamyBonus = new BigDecimal(1.975);
		break;
		case "25":
			Main.infamyBonus = new BigDecimal(2.05);
		break;
		default:
			Main.infamyBonus = new BigDecimal(0);
		break;
		}
		
		if(playerInCustodyBool) {
			switch(JOptionPane.showInputDialog(null, "How many teammates would be in custody when you escape the heist?", "Custody Check", JOptionPane.QUESTION_MESSAGE)) {
			case "1":
				Main.crewAliveBonus = new BigDecimal(0.20);
			break;
			case "2":
				Main.crewAliveBonus = new BigDecimal(0.10);
			break;
			case "3":
				Main.crewAliveBonus = new BigDecimal(0);
			break;
			} 
		} else {
			Main.crewAliveBonus = new BigDecimal(0.30);
		}
		
		if(JOptionPane.showConfirmDialog(null, "Would you get all Gage Packages?", "Gage", JOptionPane.YES_NO_OPTION) == 0) {
			Main.gagePacks = new BigDecimal(0.05);
		}else {
			Main.gagePacks = new BigDecimal(0);
		}
		
		String[] stealthBonusInput = {"0", "3", "5", "8", "10", "15", "20", "25"};
		
		switch(JOptionPane.showInputDialog(null, "How much stealth bonus percentage would you have?", "Stealth Bonus", JOptionPane.INFORMATION_MESSAGE, null, stealthBonusInput, null).toString()) {
		case "3":
			Main.stealthBonus = new BigDecimal(0.03);
		break;
		case "5":
			Main.stealthBonus = new BigDecimal(0.05);
		break;
		case "8":
			Main.stealthBonus = new BigDecimal(0.08);
		break;
		case "10":
			Main.stealthBonus = new BigDecimal(0.10);
		break;
		case "15":
			Main.stealthBonus = new BigDecimal(0.15);
		break;
		case "20":
			Main.stealthBonus = new BigDecimal(0.20);
		break;
		case "25":
			Main.stealthBonus = new BigDecimal(0.25);
		break;
		default:
			Main.stealthBonus = new BigDecimal(0);
		break;
		}
		
		repetitiveCompletion = new BigDecimal(Double.parseDouble(JOptionPane.showInputDialog(null, "How much Repetitive Completion penalty Percentage would be calculated?", "Repetitive Completion Percentage", JOptionPane.QUESTION_MESSAGE)) / 100);

		if(Main.debug == true) {
		System.out.println(Main.riskBonus);
		System.out.println(riskBonus);
		System.out.println(Main.playerInCustody);
		System.out.println(Main.perkDeckBonus);
		System.out.println(Main.infamyBonus);
		System.out.println(Main.crewAliveBonus);
		System.out.println(Main.gagePacks);
		System.out.println(Main.stealthBonus);
		System.out.println(repetitiveCompletion);
		}
	}
}
