package command_line;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.Math;

public class Task {
    private Pet pet;
    private User user;
    private final EasyTimer easyTimer = new EasyTimer();
    private final Random randGenerator = new Random();

    public Task(Pet pet, User user) {
        this.pet = pet;
        this.user = user;
    }

    public void playFetch() {
        System.out.println("Let's play fetch!");
        easyTimer.countdown(3, () -> {
            System.out.println("Fetch!");
            easyTimer.wait(10);
            System.out.println(pet.getName() + " has come back with the ball!");
            pet.modifyHappy(3);
            pet.modifyHunger(-1);
            pet.modifyThirst(-2);
            pet.modifyClean(-5);
            System.out.println("That was a good game of fetch, " + pet.getName() + " has gained 3 happiness points");
            System.out.println("What would you like to do now?");
        }, true);
    }

    public void playTugOfWar(Scanner tempListener) {
        System.out.println("Let's play tug of war");
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 10000;
        int spaceCount = 0;
        tempListener.nextLine();
        while (System.currentTimeMillis() < endTime) {
            System.out.println(spaceCount);
            String userInput = tempListener.nextLine();
            if (userInput.equals(" ")) {
                spaceCount++;
            }
        }
        System.out.println("Game Over");
        pet.modifyHappy((Math.floorDiv(spaceCount, 10)));
        pet.modifyThirst(-2);
        pet.modifyHunger(-2);
        pet.modifyClean(-3);
        System.out.println(
                pet.getName() + " has gained " + (Math.floorDiv(spaceCount, 10))
                        + " points");
        System.out.println("What would you like to do now?");
    }

    public void playPeekaboo() {
        int threshold = 2;
        int limit = 0;
        int counter = 0;
        AtomicBoolean failed = new AtomicBoolean(false);
        while (!failed.get()) {
            while (limit < 3) {
                limit = randGenerator.nextInt(20);
            }
            final int tempThresh = threshold;
            easyTimer.countdown(limit, () -> {
                System.out.println("PEEKABOO!");
                easyTimer.waitForInput(tempThresh, () -> {
                    System.out.println(" Pet: You got me!");
                    pet.modifyHappy((int) (2 / tempThresh));
                    System.out.println("That was a good game, " + pet.getName() + " has gained "
                            + (int) (2 / tempThresh) + " happiness points");
                }, () -> {
                    System.out.println("Time's up! You missed it.");
                    failed.set(true);
                });
            }, false);
            threshold /= 2;
            counter += 1;
        }
        pet.modifyHunger((-1 * counter));
    }

    public void clean(String type) {
        if (type == "Full") {
            easyTimer.countdown(900, () -> {
                System.out.println("All clean!" + pet.getName() + " has earned 90 clean points");
                pet.modifyClean(90);
            }, false);
        } else if (type == "Brush") {
            easyTimer.countdown(600, () -> {
                System.out.println("All brushed down!" + pet.getName() + " has earned 40 clean points");
                pet.modifyClean(40);
            }, false);
        } else if (type == "Partial") {
            easyTimer.countdown(300, () -> {
                System.out.println("Good enough!" + pet.getName() + " has earned 25 clean points");
                pet.modifyClean(25);
            }, false);
        } else if (type == "D&W") {
            easyTimer.countdown(60, () -> {
                System.out.println("Smelling good!" + pet.getName() + " has earned 4 clean points");
            }, false);
            pet.modifyClean(4);
        }
        System.out.println("What would you like to do now?");
    }

    public void shop(String item) {
        if (item.equals("Food")) {
            if (user.getMoney() >= 50) {
                System.out.println("You bought 1 food");
            } else {
                System.out.println("Sorry blud, you're broke");
            }
        } else if (item.equals("Treats")) {
            if (user.getMoney() >= 25) {
                System.out.println("You bought 1 treat");
            } else {
                System.out.println("Nah bruv, you're broke");
            }
        } else if (item.equals("")) {
            if (user.getMoney() >= 20) {
                System.out.println("You bought 1 training treat");
            } else {
                System.out.println("Get your bread up fam");
            }
        }
        System.out.println("What would you like to do now?");
    }

    public void work(Scanner tempListener) {
        Random rand = new Random();
        int rand_int = rand.nextInt(2);
        if (rand_int == 0) {
            System.out.println("Please type out the following, word for word, character for character.");
            String[] typingChallenge = {
                    "We adopted our furry friend from the local shelter! Their name is " + pet.getName()
                            + ", and they love cuddles and playtime. They are 123 years old, It was love at first sight when we saw them wagging tail and adorable eyes. Now, they're a cherished member of our family.",
                    "Session #1 - Teaching tricks to " + pet.getName()
                            + "! She mastered 'RollOver' and 'HighFive'. Progress is fantastic, and she's earning treats! Keep up the good work, "
                            + pet.getName() + "!",
                    "Time for a checkup! Don't forget to schedule a vet visit for " + pet.getName()
                            + ". Regular care keeps her happy and healthy. Vaccinations due in 14 days!",
                    "Join us for a playdate at the park! Bring your pets for some fun. Date: Sat, Time: 2:00 PM. Let's have a pawsitively good time!",
                    "Day 7 of our cross-country journey! Explored the mountains and encountered a friendly squirrel! "
                            + pet.getName() + "is loving the outdoors. Camping under the stars tonight." };

            Random random = new Random();
            int randomIndex = random.nextInt(typingChallenge.length);

            String randomString = typingChallenge[randomIndex];
            System.out.println("\n" + randomString);
            String answer = tempListener.nextLine();
            if (answer.equals(randomString)) {
                System.out.println("That was a bit tricky, good job! You gained $30");
                user.modifyMoney(30);
            } else {
                System.out.println("I'm not happy with your performance");
            }

        } else if (rand_int == 1) {
            System.out.println("What is the answer to the following question: ");
            String[] mathQuestions = {
                    "What is the sum of 245 and 387?",
                    "Multiply 18 by 13.",
                    "Subtract 64 from 129.",
                    "Divide 144 by 12.",
                    "Calculate the product of 7 and 9.",
                    "Add 56 and 78.",
                    "Subtract 35 from 50.",
                    "What is 3 squared?",
                    "Find the result of 25 divided by 5.",
                    "Multiply 16 by 4."
            };
            int[] mathAnswer = { 632, 234, 65, 12, 63, 134, 15, 9, 5, 6 };

            Random random = new Random();
            int randomIndex = random.nextInt(mathQuestions.length);

            String randomQuestion = mathQuestions[randomIndex];
            System.out.println("\n" + randomQuestion);
            int answer = tempListener.nextInt();
            if (answer == mathAnswer[randomIndex]) {
                System.out.println("Correct! You gain $20");
                user.modifyMoney(20);
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("What would you like to do now?");
    }

    public void feed(int foodCode, Scanner tempListener) {
        if (user.getFoodInventory().getCodesList().contains(foodCode)) {
            int index = user.getFoodInventory().getCodesList().indexOf(foodCode);
            System.out.println("\n" + user.getFoodInventory().getNamesList().get(index));
            System.out.println(user.getFoodInventory().getDescriptionsList().get(index));
            System.out.println("Are you sure you want to feed " + pet.getName() + " one "
                    + user.getFoodInventory().getNamesList().get(index) + "? Type(Y/N)");
            String verify = tempListener.nextLine();
            if (("Y").equals(verify)) {

            } else if (("N").equals(verify)) {
                System.out.println("ok, what would youl like to do?");
            }
        } else {
            System.out.println("That is not a valid food code");
        }
        System.out.println("What would you like to do now?");
    }
}
