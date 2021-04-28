package main;

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
		if(continuationPrompt.equalsIgnoreCase("Y")) {
			continueExecution = true;
		}else {
			continueExecution = false;
			System.out.println("Happy Heisting!");
		}
		} while(continueExecution);
	}
	
	private static void infoGatherPrompt() {
		System.out.println("Hello fellow Heister! Proceed to fill the requirements to do some automatic Math!\n");
		System.out.println("How many bags do you want to be calculated?");
		lootCounter = Integer.parseInt(scanner.nextLine());
		System.out.println("What difficulty do you want to be considered?\nN (0x), H (2x), VH (5x), O (10x), M (11.5x), DW (13x), DS (14x)");
		String riskBonus = scanner.nextLine();
		riskBonus.toUpperCase();
		switch(riskBonus) {
		case "N": 
			Main.riskBonus = 0;
		break;
		case "H":
			Main.riskBonus = 2;
		break;
		case "VH":
			Main.riskBonus = 5;
		break;
		case "O":
			Main.riskBonus = 10;
		break;
		case "M":
			Main.riskBonus = 11.5;
		break;
		case "DW":
			Main.riskBonus = 13;
		break;
		case "DS":
			Main.riskBonus = 14;
		break;				}
		System.out.println("Will the heist have any players in custody? Y/N");
		String playerInCustody = scanner.nextLine();
		if(playerInCustody.equalsIgnoreCase("y")) {
			Main.playerInCustody = 0.3;
		}else {
			Main.playerInCustody = 0;
		}
		System.out.println("Do you have the \"Blending In\" perk bonus in your current Perk Deck? Y/N");
		String perkDeckBonus = scanner.nextLine();
		if(perkDeckBonus.equalsIgnoreCase("Y")) {
			Main.perkDeckBonus = 0.45;
		}else {
			Main.perkDeckBonus = 0;
		}
		System.out.println("What is your Infamy level? If you do not have one, just type \"0\"");
		String infamyBonus = scanner.nextLine();
		switch(infamyBonus) {
		case "1":
			Main.infamyBonus = 0.05;
		break;
		case "2":
			Main.infamyBonus = 0.15;
		break;
		case "3":
			Main.infamyBonus = 0.20;
		break;
		case "4":
			Main.infamyBonus = 0.30;
		break;
		case "5":
			Main.infamyBonus = 0.35;
		break;
		case "6":
			Main.infamyBonus = 0.45;
		break;
		case "7":
			Main.infamyBonus = 0.50;
		break;
		case "8":
			Main.infamyBonus = 0.60;
		break;
		case "9":
			Main.infamyBonus = 0.65;
		break;
		case "10":
			Main.infamyBonus = 0.75;
		break;
		case "11":
			Main.infamyBonus = 0.825;
		break;
		case "12":
			Main.infamyBonus = 0.925;
		break;
		case "13":
			Main.infamyBonus = 1.0;
		break;
		case "14":
			Main.infamyBonus = 1.10;
		break;
		case "15":
			Main.infamyBonus = 1.175;
		break;
		case "16":
			Main.infamyBonus = 1.275;
		break;
		case "17":
			Main.infamyBonus = 1.350;
		break;
		case "18":
			Main.infamyBonus = 1.450;
		break;
		case "19":
			Main.infamyBonus = 1.525;
		break;
		case "20":
			Main.infamyBonus = 1.625;
		break;
		case "21":
			Main.infamyBonus = 1.700;
		break;
		case "22":
			Main.infamyBonus = 1.800;
		break;
		case "23":
			Main.infamyBonus = 1.875;
		break;
		case "24":
			Main.infamyBonus = 1.975;
		break;
		case "25":
			Main.infamyBonus = 2.05;
		break;
		default:
			Main.infamyBonus = 0;
		break;
		}
		System.out.println("How many teammates would be in custody when you escape the heist? Type \"0\" if everyone would escape \nRemember that the number counts only for your teammates, the bonus isn't applied with you.");
		String crewAliveBonus = scanner.nextLine();
		switch(crewAliveBonus) {
		case "1":
			Main.crewAliveBonus = 0.20;
		break;
		case "2":
			Main.crewAliveBonus = 0.10;
		break;
		case "3":
			Main.crewAliveBonus = 0;
		break;
		default:
			Main.crewAliveBonus = 0.30;
		break;
		}
		System.out.println("Would you get all Gage Packages? Y/N");
		String gagePacks = scanner.nextLine();
		if(gagePacks.equalsIgnoreCase("Y")) {
			Main.gagePacks = 0.05;
		}else {
			Main.gagePacks = 0;
		}
		System.out.println("How much stealth bonus percentage would you have (Just the number)?"); 
		String stealthBonus = scanner.nextLine();
		switch(stealthBonus) {
		case "3":
			Main.stealthBonus = 0.03;
		break;
		case "5":
			Main.stealthBonus = 0.05;
		break;
		case "8":
			Main.stealthBonus = 0.08;
		break;
		case "10":
			Main.stealthBonus = 0.10;
		break;
		case "15":
			Main.stealthBonus = 0.15;
		break;
		case "20":
			Main.stealthBonus = 0.20;
		break;
		case "25":
			Main.stealthBonus = 0.25;
		break;
		}
		System.out.println("How much Repetitive Completion penalty would be calculated? \nDue to my incompetence, use '0.(actual percentage)' to use this function");
		repetitiveCompletion = Double.parseDouble(scanner.nextLine());
//		System.out.println(Main.riskBonus);
//		System.out.println(riskBonus);
//		System.out.println(Main.playerInCustody);
//		System.out.println(Main.perkDeckBonus);
//		System.out.println(Main.infamyBonus);
//		System.out.println(Main.crewAliveBonus);
//		System.out.println(Main.gagePacks);
//		System.out.println(Main.stealthBonus);
//		System.out.println(repetitiveCompletion);
	}
}
