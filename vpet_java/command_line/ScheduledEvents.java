package command_line;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduledEvents {
    private Pet pet;
    private Timer hungerTimer;
    private Timer cleanlinessTimer;
    private Timer thirstTimer;
    private Timer happinessTimer;

    public ScheduledEvents(Pet pet) {
        this.pet = pet;
        startTimers();
    }

    public void startTimers() {
        hungerTimer = new Timer();
        cleanlinessTimer = new Timer();
        thirstTimer = new Timer();
        happinessTimer = new Timer();
        hungerTimer.scheduleAtFixedRate(new HungerReductionTask(), 0, 10000);
        cleanlinessTimer.scheduleAtFixedRate(new CleanlinessReductionTask(), 2500, 10000);
        thirstTimer.scheduleAtFixedRate(new ThirstReductionTask(), 5000, 10000);
        happinessTimer.scheduleAtFixedRate(new HappinessReductionTask(), 7500, 10000);
    }

    public void restartTimer(String field) {
        switch (field) {
            case "Hunger":
                hungerTimer.cancel();
                hungerTimer = new Timer();
                hungerTimer.scheduleAtFixedRate(new HungerReductionTask(), 10000, 10000);
                break;
            case "Cleanliness":
                cleanlinessTimer.cancel();
                cleanlinessTimer = new Timer();
                cleanlinessTimer.scheduleAtFixedRate(new CleanlinessReductionTask(), 10000, 10000);
                break;
            case "Thirst":
                thirstTimer.cancel();
                thirstTimer = new Timer();
                thirstTimer.scheduleAtFixedRate(new ThirstReductionTask(), 10000, 10000);
                break;
            case "Happiness":
                happinessTimer.cancel();
                happinessTimer = new Timer();
                happinessTimer.scheduleAtFixedRate(new HappinessReductionTask(), 10000, 10000);
                break;
            default:
                System.out.println("Invalid field provided.");
        }
    }

    private class HungerReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeHunger(1);
        }
    }

    private class CleanlinessReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeClean(1);
        }
    }

    private class ThirstReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeThirst(1);
        }
    }

    private class HappinessReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeHappy(1);
        }
    }
}
