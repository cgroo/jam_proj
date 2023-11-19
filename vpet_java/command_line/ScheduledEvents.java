package command_line;

import java.util.Timer;
import java.util.TimerTask;

public class ScheduledEvents {
    private Pet pet;

    public ScheduledEvents(Pet pet) {
        this.pet = pet;
        startScheduling();

    }

    public void startScheduling() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HungerReductionTask(), 0, 10000);
    }

    private class HungerReductionTask extends TimerTask {
        @Override
        public void run() {
            pet.removeHunger(10);
            System.out.println("Hunger reduced. Current hunger levl: " + pet.getHungerLevel());
        }
    }
}
