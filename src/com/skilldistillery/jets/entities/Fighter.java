package com.skilldistillery.jets.entities;

import java.util.Scanner;

public class Fighter extends Jet implements CombatReady {

	public Fighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	Scanner kb = new Scanner(System.in);

	public void dogfight(boolean hostiles) {
		System.out.println("Do you see hostile aircraft on the radar Y/N?");
		String choice = kb.nextLine();
		if (choice.equalsIgnoreCase("Y")) {
			hostiles = true;
			System.out.println(this.model + " Launching to engage Hostiles");
		} else {
			System.out.println("All hostiles in the area have been eliminated.");
		}
	}
}
