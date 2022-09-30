package com.alexschaffer.zookeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla throws a banana at you!");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla eats a Banana... and feels energized");
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla climbs a tree!");
		energyLevel -= 10;
	}
}
