package command_line;

public class Dog extends Pet {

	public Dog(String petName) {
		super(petName);
	}

	@Override
	public void showHappiness() {
		if (getHappinessLevel() >= 90) {
			System.out.println("Woof! :) i'm happy");
		} else if (getHappinessLevel() >= 50) {
			System.out.println("Woof :l i'm alright");
		} else {
			System.out.println("woof :( give me attention");
		}
	}

	@Override
	public void showCleanliness() {
		if (getCleanLevel() >= 90) {
			System.out.println("Woof! :) i smell great");
		} else if (getCleanLevel() >= 50) {
			System.out.println("Woof :l i'm a lil stinky");
		} else {
			System.out.println("woof :( please clean me");
		}
	}

	@Override
	public void showFullness() {
		if (getHungerLevel() >= 90) {
			System.out.println("Woof! :) i'm so full");
		} else if (getHungerLevel() >= 50) {
			System.out.println("Woof :l stomach's grumbling a bit");
		} else {
			System.out.println("woof :( please feed me");
		}
	}

	@Override
	public void showQuench() {
		if (getThirstLevel() >= 90) {
			System.out.println("Woof! :) i'm not thirsty");
		} else if (getThirstLevel() >= 50) {
			System.out.println("Woof :l i could go for some water");
		} else {
			System.out.println("woof :( i'm dying of thirst");
		}
	}

	public void trickSpin() {
		if (getHappinessLevel() > 50) {
			System.out.println(getName() + " spins around in happiness");
		}
	}

	public void trickPaw() {
		if (getHappinessLevel() > 50) {
			System.out.println(getName() + " extends their paw in happiness");
		}
	}

	public void trickSpeak() {
		if (getHappinessLevel() > 50) {
			System.out.println(getName() + " barks in happiness");
		}
	}

	public String toString() {
		String fullString = "---------------------------" + '\n';
		fullString += "| " + petName + "    Age: " + petAge + "|" + '\n';
		fullString += "| Happiness: " + happinessLevel + "     |" + '\n';
		fullString += "| Cleanliness: " + cleanLevel + "     |" + '\n';
		fullString += "| Hunger: " + hungerLevel + "     |" + '\n';
		fullString += "| Thirst: " + thirstLevel + "     |" + '\n';
		return fullString;
	}
}
