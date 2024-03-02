package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApp {
	private Airfield airfield = new Airfield();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.launch();
	}

	public void launch() {
		displayMenu();

	}

	public void displayMenu() {
		boolean running = true;
		while (running) {
			System.out.println("\n1. List Fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all cargo jets");
			System.out.println("6. Dogfight");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit\n");
			System.out.print("Choice: ");
			String choice = kb.nextLine();

			switch (choice) {
			case "1":
				airfield.listFleet();
				break;
			case "2":
				airfield.fly();
				break;
			case "3":
				airfield.viewFastestJet();
				break;
			case "4":
				airfield.viewLongestRange();
				break;
			case "5":
				airfield.loadCargo();
				break;
			case "6":
				airfield.dogfight();
				break;
			case "7":
				airfield.addJet();
				break;
			case "8":
				airfield.removeJet();
				break;
			case "9":
				running = false;
				kb.close();
				System.out.println("THank you for using JetApp FLYING THE FRIENDLY SKIES ");
				break;
			default:
				System.out.println("Not a valid option\n\n");
			}
		}
	}
}
