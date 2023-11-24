package command_line;

import java.util.ArrayList;

public class User {
	private String userName;
	private int userMoney;
	private FoodBag inventory;

	public User(String name) {
		userName = name;
		userMoney = 50;
	}

	public String getName() {
		return userName;
	}

	public int getMoney() {
		return userMoney;
	}

	public void modifyMoney(int amount) {
		userMoney += amount;
		if (userMoney < 0) {
			userMoney = 0;
		}
	}

	public void displayFoodInventory() {
		ArrayList<String> foodNames = inventory.getNamesList();
		ArrayList<Integer> foodCodes = inventory.getCodesList();
		ArrayList<String> foodDescriptions = inventory.getDescriptionsList();
	}
}
