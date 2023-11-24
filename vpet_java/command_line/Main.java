package command_line;

import java.util.Scanner;
import java.util.Random;

public class Main {
	private Pet pet;
	private User user;
	private String reason;
	private Task petTask;

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
		petTask = new Task(pet, user);
	}

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
		Scanner trickListener = new Scanner(System.in);
		// Ask nebo
		trickListener.close();
	}

	private void callPlay() {
		System.out.println("Let's play some games! What would you like to play?" + '\n');
		Scanner playListener = new Scanner(System.in);
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println("(Type: '1' for Fetch, '2' for Tug of War, '3' for Peekaboo, '0' to go back home.)");
			String playInput = playListener.nextLine();
			if (playInput == "0") {
				break;
			}

			if ("1".equals(playInput)) {
				petTask.playFetch();

			} else if ("2".equals(playInput)) {
				petTask.playTugOfWar();

			} else if ("3".equals(playInput)) {
				petTask.playPeekaboo();
			}
		}
		playListener.close();
	}

	private void callClean() {
		System.out.println("Its time to clean up! How would you like to clean your pet?" + '\n');
		Scanner cleanListener = new Scanner(System.in);
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println(
					"(Type: '1' for Full clean (15 min), '2' for Brush down (10 min), '3' for Partial clean (5) min, '4' for Deoderiser and Wipe(1 min), '0' to go back home.)");
			String cleanInput = cleanListener.nextLine();
			if (cleanInput == "0") {
				break;
			}
			if ("1".equals(cleanInput)) {
				petTask.clean("Full");
			} else if ("2".equals(cleanInput)) {
				petTask.clean("Brush");
			} else if ("3".equals(cleanInput)) {
				petTask.clean("Partial");
			} else if ("4".equals(cleanInput)) {
				petTask.clean("D&W");
			}
		}
		cleanListener.close();
	}

	private void callShop() {
		System.out.println("Let's go shopping. What would you like to buy?" + '\n');
		Scanner shopListener = new Scanner(System.in);
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println(
					"(Type '1' for Pet food ($50), Type '2' for Pet treats ($25), Type '3' for Training treats, '0' to go back home");
			String shopInput = shopListener.nextLine();
			if (shopInput == "0") {
				break;
			}
		}
		shopListener.close();
	}

	private void callWork() {
		Scanner workListener = new Scanner(System.in);
		System.out.println("Time to earn so bread." + '\n');
		while (true) {
			System.out.println("To work press type '1'. If at any point you want to go home type '0'");
			String workInput = workListener.nextLine();
			if (workInput == "1") {
				Random rand = new Random();
				int rand_int = rand.nextInt(2);
				if (rand_int == 0) {
					System.out.println("Please type out the following, word for word, character for character.");
					// List of possible prompts randomly choose one using rand_int2
				} else if (rand_int == 1) {
					System.out.println("What is the answer to the following question: ");
					// give math question and start timer
				}
			} else if (workInput == "0") {
				break;
			}
		}
		workListener.close();
	}

	private void callWater() {
		System.out.println("You fill up the water bowl");
		// Consider limiting amount of water user can get every hour, if out of water
		// need to buy from shop
	}

	private boolean checkPetDeath() {
		if (pet.getCleanLevel() == 0) {
			reason = "Stinkiness";
			return true;
		}
		if (pet.getHappinessLevel() == 0) {
			reason = "Depression";
			return true;
		}
		if (pet.getHungerLevel() == 0) {
			reason = "Malnurishment";
			return true;
		}
		if (pet.getThirstLevel() == 0) {
			reason = "drinking dirty ass drain water cause you neglected their thirst";
			return true;
		}
		return true;
	}

	private void endGame() {
		System.out.println("Game Over. Your pet has died of " + reason);
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
			} else {
				System.out.println("Command not recognised, please try again.");
			}
			boolean check = checkPetDeath();
			if (check) {
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
		petAttributeDecay.endTimers();
	}
}
