package command_line;

public class Pet {

	String petName;
	int petAge = 1;
	int cleanLevel = 50;
	int hungerLevel = 50;
	int thirstLevel = 50;
	int happinessLevel = 50;

	public Pet(String name) {
		petName = name;
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

	public void showHappiness() {
		System.out.println("Generic Method");
	}

	public void showCleanliness() {
		System.out.println("Generic Method");
	}

	public void showFullness() {
		System.out.println("Generic Method");
	}

	public void showQuench() {
		System.out.println("Generic Method");
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

	private String buildSpaces(String value, String field) {
		String spaces = "";
		for (int i = 0; i < 19 - value.length() - field.length(); i++) {
			spaces += " ";
		}
		return spaces;
	}

	public String toString() {
		String spaces = "";
		String fullString = "-------------------------" + '\n';
		spaces = buildSpaces(petName, "Name");
		fullString += "| Name: " + spaces + petName + " |" + '\n';

		spaces = buildSpaces(String.valueOf(petAge), "Age");
		fullString += "| Age: " + spaces + petAge + " |" + '\n';

		spaces = buildSpaces(String.valueOf(happinessLevel), "Happiness");
		fullString += "| Happiness: " + spaces + happinessLevel + " |" + '\n';

		spaces = buildSpaces(String.valueOf(cleanLevel), "Cleanliness");
		fullString += "| Cleanliness: " + spaces + cleanLevel + " |" + '\n';

		spaces = buildSpaces(String.valueOf(hungerLevel), "Hunger");
		fullString += "| Hunger: " + spaces + hungerLevel + " |" + '\n';

		spaces = buildSpaces(String.valueOf(thirstLevel), "Thirst");
		fullString += "| Thirst: " + spaces + thirstLevel + " |" + '\n';

		fullString += "-------------------------" + '\n';
		return fullString;
	}

	public void listOfTricks() {
		System.out.println("Generic Method");
	}
}
