package com.skilldistillery.jets.entities;

public abstract class Jet {

	protected String model;
	protected double speed;
	protected int range;
	protected long price;

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;

	}

	public void fly() {
		double flightTime = range / speed;
		if (range == 0 || speed == 0) {
			System.out.println("This aircraft is not operational, it's down for maintenance.");
		} else {
			System.out.println("Flight time available: " + flightTime);
			System.out.println(model + speed + range + price);
		}

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

}
