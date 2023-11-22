package command_line;

public class Cat extends Pet {

	public Cat(String petName) {
		super(petName);
	}

	public void showHappiness() {
		if (this.happinessLevel >= 90) {
			System.out.println("Meow! :) i'm happy");
		} else if (this.happinessLevel >= 50) {
			System.out.println("Meow :l i'm alright");
		} else {
			System.out.println("meow :( give me attention");
		}
	}

	public void showCleanliness() {
		if (this.cleanLevel >= 90) {
			System.out.println("Meow! :) i smell great");
		} else if (this.cleanLevel >= 50) {
			System.out.println("Meow :l i'm a lil stinky");
		} else {
			System.out.println("meow :( please clean me");
		}
	}

	public void showFullness() {
		if (this.hungerLevel >= 90) {
			System.out.println("Meow! :) i'm so full");
		} else if (this.hungerLevel >= 50) {
			System.out.println("Meow :l stomach's grumbling a bit");
		} else {
			System.out.println("meow :( please feed me");
		}
	}

	public void showQuench() {
		if (this.thirstLevel >= 90) {
			System.out.println("Meow! :) i'm not thirsty");
		} else if (this.hungerLevel >= 50) {
			System.out.println("Meow :l i could go for some water");
		} else {
			System.out.println("meow :( i'm dying of thirst");
		}
	}
}
