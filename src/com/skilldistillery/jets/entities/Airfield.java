package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Airfield {
	private List<Jet> squadron = new ArrayList<>();
	Scanner kb = new Scanner(System.in);

	public Airfield() {
		readJets();

	}
	// read the jest, 1 line / time, from file
	// String aJetThing = the line from the file
	// String aJetThing = Passenger,C12F,334,2270,2000000
	// String [] jetPieces = aJetThing.split(",");
	// for (String piece : jetPieces) {
	// sysout (piece)

	public void readJets() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("Jets.txt"));

			String line;
			while ((line = reader.readLine()) != null) {
				String[] jetPieces = line.split(",");
				if (jetPieces[0].equals("Fighter")) {
					Fighter fighter = new Fighter(jetPieces[1], Double.parseDouble(jetPieces[2]),
							Integer.parseInt(jetPieces[3]), Long.parseLong(jetPieces[4]));
					squadron.add(fighter);
				} else if (jetPieces[0].equals("Cargo")) {
					Cargo cargo = new Cargo(jetPieces[1], Double.parseDouble(jetPieces[2]),
							Integer.parseInt(jetPieces[3]), Long.parseLong(jetPieces[4]));
					squadron.add(cargo);
				} else if (jetPieces[0].equals("Passenger")) {
					Passenger passenger = new Passenger(jetPieces[1], Double.parseDouble(jetPieces[2]),
							Integer.parseInt(jetPieces[3]), Long.parseLong(jetPieces[4]));
					squadron.add(passenger);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void dogfight() {
		for (Jet jet : squadron) {
			if (jet instanceof Fighter) {
				((Fighter) jet).dogfight();

			}
		}

	}

	public void removeJet() {
		for (int i = 0; i < squadron.size(); i++) {
			System.out.println(i + 1 + ". " + squadron.get(i));
		}

		System.out.print("\nSelect the number of the jet to delete: ");
		try {
			int choice = kb.nextInt();
			if (choice < squadron.size() + 1 && choice > 0) {
				System.out.println("\n" + squadron.get(choice - 1).getModel() + " deleted\n");
				squadron.remove(choice - 1);
			} else {
				System.out.println("Not a valid choice");
			}

		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
			kb.nextLine();
		}
	}

	public void addJet() {
		try {
			System.out.println("Choose a type: \n1.Fighter \n2.Cargo \n3.Passenger ");
			String choice = kb.nextLine();
			String type = "";
			if (choice.equals("1")) {
				type = "Fighter";
			}
			if (choice.equals("2")) {
				type = "Cargo";
			}
			if (choice.equals("3")) {
				type = "Passenger";
			}
			System.out.println("Enter the aircraft model: \n ");
			String model = kb.nextLine();
			System.out.println("Enter the max speed: \n");
			double speed = kb.nextDouble();
			System.out.println("Enter the max range: \n");
			int range = kb.nextInt();
			System.out.println("Enter the price of the aircraft: \n");
			long price = kb.nextLong();
			if (type.equals("Fighter")) {
				Fighter fighter = new Fighter(model, speed, range, price);
				squadron.add(fighter);
			}

			else if (type.equals("Cargo")) {
				Cargo cargo = new Cargo(model, speed, range, price);
				squadron.add(cargo);
			}

			else if (type.equals("Passenger")) {
				Passenger passenger = new Passenger(model, speed, range, price);
				squadron.add(passenger);
			}

			System.out.println("Added a new aircraft to the Squadron.");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
			kb.nextLine();
		}
	}

	public void loadCargo() {
		for (Jet jet : squadron) {
			if (jet instanceof Cargo) {
				((Cargo) jet).loadCargo();
			}
		}

	}

	public void viewLongestRange() {
		long longestRange = 0;
		Jet jetWithLongestRange = null;
		for (Jet jet : squadron) {
			if (jet.getRange() > longestRange) {
				jetWithLongestRange = jet;
				longestRange = jet.range;
			}
		}
		System.out.println("The aircraft with the longest range is: " + jetWithLongestRange + "\nWith a max range of: "
				+ longestRange);
	}

	public void viewFastestJet() {
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : squadron) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.speed;
				fastestJet = jet;
			}
		}
		System.out
				.println("The aircraft with the fastestSpeed is: " + fastestJet + "\nWith a speed of: " + fastestSpeed);
	}

	public void fly() {
		for (Jet jet : squadron) {
			jet.fly();

		}

	}

	public void listFleet() {
		for (Jet jet : squadron) {
			System.out.println(jet);

		}
	}

}
