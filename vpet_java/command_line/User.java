package command_line;

public class User {
	String userName;
	int userMoney;

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
}
