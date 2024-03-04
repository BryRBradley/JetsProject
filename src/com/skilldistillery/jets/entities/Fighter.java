package com.skilldistillery.jets.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fighter extends Jet implements CombatReady {

	public Fighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	Scanner kb = new Scanner(System.in);

	public void dogfight() {
		try {
			System.out.println("Do you see hostile aircraft on the radar Y/N?");
			boolean hostiles = true;
			while (hostiles) {
				String choice = kb.nextLine();
				if (choice.equalsIgnoreCase("Y")) {
					hostiles = true;
					System.out.println(this.model + " Launching to engage Hostiles");
					continue;
				}

				else {
					System.out.println("No hostiles in the area.");
					hostiles = false;
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
			kb.nextLine();
		}

	}
}
