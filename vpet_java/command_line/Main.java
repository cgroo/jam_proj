package command_line;

import java.util.Scanner;

public class Main {
	private Pet pet;
	private User user;

	private void initialise() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		System.out.println("What pet do you want? (Type Dog, Rat, or Cat)");
		String petType = input.nextLine();
		System.out.println("What is the name of your new pet?");
		String petName = input.nextLine();
		input.close();

		user = new User(name);
		if (petType.toLowerCase().equals("dog")) {
			pet = new Dog(petName);
		}
		if (petType.toLowerCase().equals("cat")) {
			pet = new Cat(petName);
		}
		if (petType.toLowerCase().equals("rat")) {
			pet = new Rat(petName);
		}
	}

	/**
	 * public void petTesting() {
	 * if (pet instanceof Dog) {
	 * System.out.println(pet);
	 * pet.listOfTricks();
	 * }
	 * 
	 * else if (pet instanceof Cat) {
	 * System.out.println(pet);
	 * }
	 * 
	 * else if (pet instanceof Rat) {
	 * System.out.println(pet);
	 * 
	 * } else {
	 * System.out.println("Unsupported Pet Type");
	 * }
	 * }
	 * 
	 */

	private void gameRules() {
		System.out.println("Welcome to 'this game' (STC)  ");
		System.out.println("Here are the rules of the game:");
		System.out.println(
				"You will soon be assigned a pet. This pet is real; a living organism, and you musn't let it die");
		System.out
				.println("Your pet has many attibutes such as its Happiness, its Cleanliness, its Hunger and Thirst.");
		System.out.println("It is vital that you keep these attributes up to keep your pet alive");
		System.out
				.println("If at any point your pet has 1 attribute at 0, you lose and both you and your pet WILL DIE");
		System.out.println(
				"To keep your pet happy you can teach them tricks and play games by typing 'Tricks' and 'Play' respectively");
		System.out.println("To keep your pet clean you must wipe them down and bath them by typing 'Clean'");
		System.out.println(
				"To keep your pet full you must feed them regularly by buying food with your money accumulated by tasks. These menus are accessed via 'Shop' and 'Work'");
		System.out.println("To keep your pet quenched you must give them water regularly by typing 'Water'");
		System.out.println("If at any point you need a reminder of the keywords type 'Help");
		System.out.println("We hope you enjoy the game and remember");
		System.out.println("Don't let your pet die" + '\n');
		System.out.println("Keywords: 'Tricks', 'Play', 'Clean', 'Shop', 'Work', 'Water'");

	}

	private void callTrick() {

	}

	private void callPlay() {

	}

	private void callClean() {

	}

	private void callShop() {

	}

	private void callWork() {

	}

	private void callWater() {

	}

	private Boolean checkPet() {
		if (pet.getCleanLevel() == 0) {
			return true;
		}
		if (pet.getHappinessLevel() == 0) {
			return true;
		}
		if (pet.getHungerLevel() == 0) {
			return true;
		}
		if (pet.getThirstLevel() == 0) {
			return true;
		}
		return false;
	}

	private void endGame() {
		System.out.println("Game Over. Your pet has died of {the reason}");
		System.out.println("Put the user's stats for their run");
		user = null;
		pet = null;
	}

	private void mainLogic() {
		Scanner listen = new Scanner(System.in);
		while (true) {
			String input = listen.nextLine();

			if ("trick".equals(input.toLowerCase())) {
				callTrick();
			} else if ("play".equals(input.toLowerCase())) {
				callPlay();
			} else if ("clean".equals(input.toLowerCase())) {
				callClean();
			} else if ("shop".equals(input.toLowerCase())) {
				callShop();
			} else if ("work".equals(input.toLowerCase())) {
				callWork();
			} else if ("water".equals(input.toLowerCase())) {
				callWater();
			}

			else {
				System.out.println("Command not recognised, please try again.");
			}

			if (checkPet()) {
				break;
			}

		}
		listen.close();
	}

	public static void main(String[] args) {
		Main newProgram = new Main();
		newProgram.initialise();
		ScheduledEvents petAttributeDecay = new ScheduledEvents(newProgram.pet);
		// newProgram.petTesting();
		newProgram.gameRules();
		newProgram.mainLogic();
		newProgram.endGame();

	}

}
