package command_line;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduledEvents {
    private Pet pet;
    private Timer hungerTimer;
    private Timer cleanlinessTimer;
    private Timer thirstTimer;
    private Timer happinessTimer;

    private static int gameSeconds;

    public ScheduledEvents(Pet pet) {
        this.pet = pet;
        startTimers();

    }

    public void startTimers() {
        hungerTimer = new Timer();
        cleanlinessTimer = new Timer();
        thirstTimer = new Timer();
        happinessTimer = new Timer();
        hungerTimer.scheduleAtFixedRate(new HungerReductionTask(), 10000, 10000);
        cleanlinessTimer.scheduleAtFixedRate(new CleanlinessReductionTask(), 10000, 10000);
        thirstTimer.scheduleAtFixedRate(new ThirstReductionTask(), 10000, 10000);
        happinessTimer.scheduleAtFixedRate(new HappinessReductionTask(), 10000, 10000);
    }

    public void restartTimer() {
        if (gameSeconds % 40 == 0) {
            hungerTimer.cancel();
            hungerTimer = new Timer();
            hungerTimer.scheduleAtFixedRate(new HungerReductionTask(), 10000, 10000);
        }
        if (gameSeconds % 40 == 10) {
            cleanlinessTimer.cancel();
            cleanlinessTimer = new Timer();
            cleanlinessTimer.scheduleAtFixedRate(new CleanlinessReductionTask(), 10000, 10000);
        }
        if (gameSeconds % 40 == 20) {
            thirstTimer.cancel();
            thirstTimer = new Timer();
            thirstTimer.scheduleAtFixedRate(new ThirstReductionTask(), 10000, 10000);
        }
        if (gameSeconds % 40 == 30) {
            happinessTimer.cancel();
            happinessTimer = new Timer();
            happinessTimer.scheduleAtFixedRate(new HappinessReductionTask(), 10000, 10000);
        }
    }

    private class HungerReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeHunger(10);
            System.out.println("Hunger reduced. Current hunger level: " + pet.getHungerLevel());
        }
    }

    private class CleanlinessReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeClean(10);
            System.out.println("Cleanliness reduced. Current cleanliness level: " + pet.getCleanLevel());
        }
    }

    private class ThirstReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeThirst(10);
            System.out.println("Thirst reduced. Current thirst level: " + pet.getThirstLevel());
        }
    }

    private class HappinessReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeHappy(10);
            System.out.println("Happiness reduced. Current happiness level: " + pet.getHappinessLevel());
        }
    }

    public static void main(String[] args) {
        Pet pet = new Dog("Chonccy");
        ScheduledEvents timedEvents = new ScheduledEvents(pet);
        Timer testTimer = new Timer();
        testTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gameSeconds++;
                System.out.println(gameSeconds);
            }
        }, 0, 1000);
        while (true) {
            timedEvents.restartTimer();
        }
    }
}
