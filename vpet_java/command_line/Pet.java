package command_line;

public class Pet {
	
	String petName;
	int petAge = 0;
	int cleanLevel = 50;
	int hungerLevel = 50;
	int thirstLevel = 50;
	int happinessLevel = 50;
	
	public Pet(String name, String type) {
		if (type == "dog") {
			
		}
	}
	
	public String getName() {
		return petName;
	}
	
	public int getAge() {
		return petAge;
	}
	
	public int getCleanLevel() {
		return cleanLevel;
	}
	
	public int getHungerLevel() {
		return hungerLevel;
	}
	
	public int getThirstLevel() {
		return thirstLevel;
	}
	
	public int getHappinessLevel() {
		return happinessLevel;
	}
	
	public void setName(String name) {
		petName = name;
	}
	
	public void incrementAge() {
		petAge += 1;
	}
	
	public void addClean(int amount) {
		cleanLevel += amount;
		if (cleanLevel > 100) {
			cleanLevel = 100;
		}
	}
	
	public void removeClean(int amount) {
		cleanLevel -= amount;
		if (cleanLevel < 0) {
			cleanLevel = 0;
		}
	}
	
	public void addHunger(int amount) {
		hungerLevel += amount;
		if (hungerLevel > 100) {
			hungerLevel = 100;
		}
	}
	
	public void removeHunger(int amount) {
		hungerLevel -= amount;
		if (hungerLevel < 0) {
			hungerLevel = 0;
		}
	}
	
	public void addThirst(int amount) {
		thirstLevel += amount;
		if (thirstLevel > 100) {
			thirstLevel = 100;
		}
	}
	
	public void removeThirst(int amount) {
		thirstLevel -= amount;
		if (thirstLevel < 0) {
			thirstLevel = 0;
		}
	}
	
	public void addHappy(int amount) {
		happinessLevel += amount;
		if (happinessLevel > 100) {
			happinessLevel = 100;
		}
	}
	
	public void removeHappy(int amount) {
		happinessLevel -= amount;
		if (happinessLevel < 0) {
			happinessLevel = 0;
		}
	}
	
	
}
