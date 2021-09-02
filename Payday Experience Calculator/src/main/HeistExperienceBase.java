package main;

import java.math.BigDecimal;
import java.util.Scanner;

public class HeistExperienceBase extends HeistEXPCalculator{
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void heistExperienceLoop() {
		Boolean continueExecution;
		do {
		infoGatherPrompt();
		eXPFormula();
		System.out.println("Do you want to repeat the calculations back from the start again? Y/N");
		String continuationPrompt = scanner.nextLine();
		if(continuationPrompt.equalsIgnoreCase("y")) {
			continueExecution = true;
		}else {
			continueExecution = false;
			scanner.close();
			System.out.println("Happy Heisting!");
		}
		} while(continueExecution);
	}
	
	private static void infoGatherPrompt() {
		System.out.println("How many bags do you want to be calculated?");
		lootCounter = Integer.parseInt(scanner.nextLine());
		System.out.println("What difficulty do you want to be considered?\nN (0x), H (2x), VH (5x), O (10x), M (11.5x), DW (13x), DS (14x)");
		String riskBonus = scanner.nextLine();
		switch(riskBonus.toUpperCase()) {
		case "N": 
			Main.riskBonus = new BigDecimal(0);
		break;
		case "H":
			Main.riskBonus = new BigDecimal(2.0);
		break;
		case "VH":
			Main.riskBonus = new BigDecimal(5.0);
		break;
		case "O":
			Main.riskBonus = new BigDecimal(10.0);
		break;
		case "M":
			Main.riskBonus = new BigDecimal(11.5);
		break;
		case "DW":
			Main.riskBonus = new BigDecimal(13.0);
		break;
		case "DS":
			Main.riskBonus = new BigDecimal(14.0);
		break;				
		}
		System.out.println("Will the heist have any players in custody? Y/N");
		String playerInCustody = scanner.nextLine();
		if(playerInCustody.equalsIgnoreCase("y")) {
			Main.playerInCustody = new BigDecimal(0.3);
		}else {
			Main.playerInCustody = new BigDecimal(0);
		}
		System.out.println("Do you have the \"Blending In\" perk bonus in your current Perk Deck? Y/N");
		String perkDeckBonus = scanner.nextLine();
		if(perkDeckBonus.equalsIgnoreCase("y")) {
			Main.perkDeckBonus = new BigDecimal(0.45);
		}else {
			Main.perkDeckBonus = new BigDecimal(0);
		}
		System.out.println("What is your Infamy level? If you do not have one, just type \"0\"");
		String infamyBonus = scanner.nextLine();
		switch(infamyBonus) {
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
		System.out.println("How many teammates would be in custody when you escape the heist? Type \"0\" if everyone would escape \nRemember that the number counts only for your teammates, the bonus isn't applied with you.");
		String crewAliveBonus = scanner.nextLine();
		switch(crewAliveBonus) {
		case "1":
			Main.crewAliveBonus = new BigDecimal(0.20);
		break;
		case "2":
			Main.crewAliveBonus = new BigDecimal(0.10);
		break;
		case "3":
			Main.crewAliveBonus = new BigDecimal(0);
		break;
		default:
			Main.crewAliveBonus = new BigDecimal(0.30);
		break;
		}
		System.out.println("Would you get all Gage Packages? Y/N");
		String gagePacks = scanner.nextLine();
		if(gagePacks.equalsIgnoreCase("y")) {
			Main.gagePacks = new BigDecimal(0.05);
		}else {
			Main.gagePacks = new BigDecimal(0);
		}
		System.out.println("How much stealth bonus percentage would you have (Just the number)?"); 
		String stealthBonus = scanner.nextLine();
		switch(stealthBonus) {
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
		System.out.println("How much Repetitive Completion penalty would be calculated? \n Use \"0.xx\" Syntax to represent the percentages");
		repetitiveCompletion = scanner.nextBigDecimal();
		scanner.nextLine();
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
