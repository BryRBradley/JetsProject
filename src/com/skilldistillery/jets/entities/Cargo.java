package com.skilldistillery.jets.entities;

public class Cargo extends Jet implements CargoCarrier {

	public Cargo(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	public void loadCargo() {
		System.out.println("Cargo is loaded on " + this.model);

	}
}
