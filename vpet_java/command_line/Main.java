package command_line;

import java.util.Scanner;

public class Main {
	private Pet pet;
	private User user;

	public void initialise() {
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

	public void petTesting() {
		if (pet instanceof Dog) {
			System.out.println(pet);
			pet.listOfTricks();
		}

		else if (pet instanceof Cat) {
			System.out.println(pet);
		}

		else if (pet instanceof Rat) {
			System.out.println(pet);

		} else {
			System.out.println("Unsupported Pet Type");
		}
	}

	public static void main(String[] args) {
		Main newProgram = new Main();
		newProgram.initialise();
		newProgram.petTesting();

	}

}
