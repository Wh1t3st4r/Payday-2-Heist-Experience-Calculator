package main;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main extends HeistEXPCalculator {

	public static Scanner scanner = new Scanner(System.in);
	static boolean debug = true;

	public static void main(String[] args) {
	  String[] options = {"HEXP", "EXPC", "Exit"};
	  int input = JOptionPane.showOptionDialog(null, "Select which service do you want. \"HEXP\" for the Heist Experience Calculator; \"EXPC\" for the Experience Calculator", 
			  "Select your service", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
	  switch(input) {
	  case 0: HeistExperienceBase.heistExperienceLoop();
	  break;
	  case 1: ExperienceCalculator.mainArrangement();
	  break;
	  }
	}
}
