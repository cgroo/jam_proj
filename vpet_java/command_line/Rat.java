package command_line;

public class Rat extends Pet{
	public Rat() {
	public void showHappiness() {
		if (this.happinessLevel >= 90) {
			System.out.println("Squeak! :) i'm happy");
		}
		else if (this.happinessLevel >= 50) {
			System.out.println("Squeak :l i'm alright");
		}
		else {
			System.out.println("squeak :( give me attention");
		}
	}
		
	public void showCleanliness() {
		if (this.cleanLevel >= 90) {
			System.out.println("Squeak! :) i smell great");
		}
		else if (this.cleanLevel >= 50) {
			System.out.println("Squeak :l i'm a lil stinky");
		}
		else {
			System.out.println("squeak :( please clean me");
		}
	}
	
	public void showFullness() {
		if (this.hungerLevel >= 90) {
			System.out.println("Squeak! :) i'm so full");
		}
		else if (this.hungerLevel >= 50) {
			System.out.println("Squeak :l stomach's grumbling a bit");
		}
		else {
			System.out.println("squeak :( please feed me");
		}
	}
	
	public void showQuench() {
		if (this.thirstLevel >= 90) {
			System.out.println("Squeak! :) i'm not thirsty");
		}
		else if (this.hungerLevel >= 50) {
			System.out.println("Squeak :l i could go for some water");
		}
		else {
			System.out.println("squeak :( i'm dying of thirst");
		}
	}
}
