package command_line;

import java.util.Scanner;

public class Main {
	private Pet pet;
	private User user;
	private String reason;
	private Task petTask;

	private void initialise(Scanner listener) {
		System.out.println("What is your name?");
		String name = listener.nextLine();
		System.out.println("What pet do you want? (Type Dog, Rat, or Cat)");
		String petType = listener.nextLine();
		System.out.println("What is the name of your new pet?");
		String petName = listener.nextLine();

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
		System.out.println("Keywords: 'Tricks', 'Play', 'Clean', 'Shop', 'Work', 'Water', 'Stats");
	}

	private void callAttributes() {
		System.out.println(pet);
	}

	private void callTrick() {
		Scanner trickListener = new Scanner(System.in);
		// Ask nebo
		trickListener.close();
	}

	private void callPlay(Scanner playListener) {
		System.out.println("Let's play some games! What would you like to play?" + '\n');
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println("(Type: '1' for Fetch, '2' for Tug of War, '3' for Peekaboo, '0' to go back home.)");
			int playInput = playListener.nextInt();
			if (playInput == 0) {
				break;
			} else if (playInput == 1) {
				petTask.playFetch();

			} else if (playInput == 2) {
				petTask.playTugOfWar(playListener);

			} else if (playInput == 3) {
				petTask.playPeekaboo();
			}
		}
	}

	private void callClean(Scanner cleanListener) {
		System.out.println("Its time to clean up! How would you like to clean your pet?" + '\n');
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println(
					"(Type: '1' for Full clean (15 min), '2' for Brush down (10 min), '3' for Partial clean (5) min, '4' for Deoderiser and Wipe(1 min), '0' to go back home.)");
			int cleanInput = cleanListener.nextInt();
			if (cleanInput == 0) {
				break;
			} else if (cleanInput == 1) {
				petTask.clean("Full");
			} else if (cleanInput == 2) {
				petTask.clean("Brush");
			} else if (cleanInput == 3) {
				petTask.clean("Partial");
			} else if (cleanInput == 4) {
				petTask.clean("D&W");
			}
		}
	}

	private void callShop(Scanner shopListener) {
		System.out.println("Let's go shopping. What would you like to buy?" + '\n');
		while (true) {
			System.out.println("Type 'INFO' for more information on the options");
			System.out.println(
					"(Type '1' for Pet food ($50), Type '2' for Pet treats ($25), Type '3' for Training treats($20), '0' to go back home");
			int shopInput = shopListener.nextInt();
			if (shopInput == 0) {
				break;
			} else if (user.getMoney() > 0) {
				System.out.println("Nah bro, you're broke");
			} else if (shopInput == 1) {
				petTask.shop("Food");
			} else if (shopInput == 2) {
				petTask.shop("Treats");
			} else if (shopInput == 3) {
				petTask.shop("Training");
			}
		}
	}

	private void callWork(Scanner workListener) {
		System.out.println("Time to earn so bread." + '\n');
		while (true) {
			System.out.println("To work press type '1'. If at any point you want to go home type '0'");
			int workInput = workListener.nextInt();
			if (workInput == 0) {
				break;
			} else if (workInput == 1) {
				petTask.work(workListener);
			}
		}
	}

	private void callFood(Scanner foodListener) {
		while (true) {
			System.out.println("Please enter the food code or '0' to go back");
			user.displayFoodInventory();
			int foodInput = foodListener.nextInt();
			if (foodInput == 0) {
				break;
			} else {
				petTask.feed(foodInput, foodListener);
			}
		}
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
		return false;
	}

	private void endGame() {
		System.out.println("Game Over. Your pet has died of " + reason);
		System.out.println("Put the user's stats for their run");
		user = null;
		pet = null;
		reason = null;
		petTask = null;
	}

	private void mainLogic(Scanner listener) {
		System.out.println(pet);
		while (true) {
			String input = listener.nextLine();
			if ("trick".equals(input.toLowerCase())) {
				callTrick();
			} else if ("play".equals(input.toLowerCase())) {
				callPlay(listener);
			} else if ("clean".equals(input.toLowerCase())) {
				callClean(listener);
			} else if ("shop".equals(input.toLowerCase())) {
				callShop(listener);
			} else if ("work".equals(input.toLowerCase())) {
				callWork(listener);
			} else if ("food".equals(input.toLowerCase())) {
				callFood(listener);
			} else if ("water".equals(input.toLowerCase())) {
				callWater();
			} else if ("stats".equals(input.toLowerCase())) {
				callAttributes();
			} else {
				System.out.println("Command not recognized, please try again.");
			}
			boolean check = checkPetDeath();
			if (check) {
				break;
			}

		}
		listener.close();
	}

	public static void main(String[] args) {
		Scanner universalScanner = new Scanner(System.in);
		Main newProgram = new Main();
		newProgram.initialise(universalScanner);
		ScheduledEvents petAttributeDecay = new ScheduledEvents(newProgram.pet);
		// newProgram.petTesting();
		newProgram.gameRules();
		newProgram.mainLogic(universalScanner);
		newProgram.endGame();
		petAttributeDecay.endTimers();
	}
}
