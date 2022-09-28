package com.alexschaffer.zookeeper;

public class Bat extends Mammal{
	
	Integer energyLevel = 300;
	
	public void fly() {
		System.out.println("Eeek! Eeek! Eeek! Eeek!");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("the sound of a town burning in the middle of the night.");
		energyLevel -= 100;
	}
	
}
