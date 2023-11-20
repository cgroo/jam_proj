package command_line;
import java.util.Scanner;

public class Main {
	private Pet pet;
	private User user;
	
	public void startUp() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		System.out.println("What pet do you want? (Type Dog)");
		String petType = input.nextLine();
		System.out.println("What is the name of your new pet?");
		String petName = input.nextLine();
		input.close();
		user = new User(name);
		if (petType.toLowerCase().equals("dog")) {
			pet = new Dog(petName);
		}

	}
	
	public void petTesting() {
		if (pet instanceof Dog) {
			Dog dog = (Dog)pet;
			dog.showCleanliness(); //should be a lil stinky becuz dog is = 50 
			dog.addClean(40);
			dog.showCleanliness(); //should be smelling great now
			dog.removeClean(80);
			dog.showCleanliness(); //should be smelling like angelo's fart
			

		}
		else {
			System.out.println("Unsupported Pet Type");
		}
	}
	
	public static void main(String[] args) {
		Main newProgram = new Main();
		newProgram.startUp();
		newProgram.petTesting();
	}

}
