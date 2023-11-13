package command_line;

public class Dog extends Pet{
	
	
	public Dog() {
		
	}
	public void showHappiness() {
		if (this.happinessLevel >= 90) {
			System.out.println("Woof! :) i'm happy");
		}
		else if (this.happinessLevel >= 50) {
			System.out.println("Woof :l i'm alright");
		}
		else {
			System.out.println("woof :( give me attention");
		}
	}
		
	public void showCleanliness() {
		if (this.cleanLevel >= 90) {
			System.out.println("Woof! :) i smell great");
		}
		else if (this.cleanLevel >= 50) {
			System.out.println("Woof :l i'm a lil stinky");
		}
		else {
			System.out.println("woof :( please clean me");
		}
	}
	
	public void showFullness() {
		if (this.hungerLevel >= 90) {
			System.out.println("Woof! :) i'm so full");
		}
		else if (this.hungerLevel >= 50) {
			System.out.println("Woof :l stomach's grumbling a bit");
		}
		else {
			System.out.println("woof :( please feed me");
		}
	}
	
	public void showQuench() {
		if (this.thirstLevel >= 90) {
			System.out.println("Woof! :) i'm not thirsty");
		}
		else if (this.hungerLevel >= 50) {
			System.out.println("Woof :l i could go for some water");
		}
		else {
			System.out.println("woof :( i'm dying of thirst");
		}
	}
	
	public void trickSpin() {
		if (this.getHappinessLevel() > 50) {
			System.out.println(this.getName()+" spins around in happiness");
		}
	}
	
	public void trickPaw() {
		if (this.getHappinessLevel() > 50) {
			System.out.println(this.getName()+" extends their paw in happiness");
		}
	}
	
	public void trickSpeak() {
		if (this.getHappinessLevel() > 50) {
			System.out.println(this.getName()+" barks in happiness");
		}
	}
}
