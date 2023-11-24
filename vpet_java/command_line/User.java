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

	public FoodBag getFoodInventory() {
		return inventory;
	}

	public void displayFoodInventory() {
		ArrayList<String> foodNames = inventory.getNamesList();
		ArrayList<Integer> foodCodes = inventory.getCodesList();
		ArrayList<Integer> foodQuantity = inventory.getQuantityList();
		System.out.println("Food Names  |  Food Code  | Food Quantity");
		for (int i = 0; i < foodNames.size(); i++) {
			System.out.println(foodNames.get(i) + "     " + foodCodes.get(i) + "      x" + foodQuantity.get(i));
		}
	}
}
