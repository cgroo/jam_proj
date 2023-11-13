package command_line;
import java.util.Scanner;

public class Main {
	private Pet pet;
	private User user;
	
	public void startUp() {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		System.out.println("What pet do you want? (Type Dog, Cat or Rat)");
		String petType = input.nextLine();
		user = new User(name);
		input.close();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
