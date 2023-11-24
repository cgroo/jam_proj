package command_line;

public class User {
	private String userName;
	private int userMoney;

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
}
