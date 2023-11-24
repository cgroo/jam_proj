package command_line;

import java.util.Scanner;
import java.lang.Math;

public class Task {
    private Pet pet;
    private final EasyTimer easyTimer = new EasyTimer();

    public Task(Pet pet) {
        this.pet = pet;
    }

    public void playFetch() {
        System.out.println("Let's play fetch!");
        easyTimer.countdown(3, () -> {
            System.out.println("Fetch!");
            easyTimer.wait(10);
            System.out.println(pet.getName() + " has come back with the ball!");
            pet.modifyHappy(4);
            pet.modifyHunger(-1);
            pet.modifyThirst(-2);
        });
    }

    public void playTugOfWar() {
        Scanner tempListener = new Scanner(System.in);
        double spaceCount = 0;
        System.out.println("Let's play tug of war");
        easyTimer.countdown(10, () -> {
            System.out.println("Game Over");
        });
        while (true) {
            String tugInput = tempListener.nextLine();
            if (tugInput.equals(" ")) {
                spaceCount += 1;
            }
            if (easyTimer.getRemainingTime() == 0) {
                break;
            }
        }
        double amount = Math.floor((spaceCount / 10));
        pet.modifyHappy((int) amount);
        tempListener.close();
    }
}
