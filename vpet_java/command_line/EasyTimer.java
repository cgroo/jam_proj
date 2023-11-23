package command_line;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EasyTimer {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private long startTime;
    private long duration;
    private boolean timerOn;

    public void countdown(int seconds, Runnable actionOnCompletion) {
        this.startTime = System.currentTimeMillis();
        this.duration = seconds * 1000L;
        this.timerOn = true;
        executorService.schedule(() -> {
            for (int i = seconds; i > 0; i--) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (actionOnCompletion != null) {
                actionOnCompletion.run();
            }
        }, 0, TimeUnit.SECONDS);
    }

    public long getRemainingTime() {
        return duration - (System.currentTimeMillis() - startTime);
    }

    public void wait(int seconds) {
        executorService.schedule(() -> {
            for (int i = seconds; i > 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, 0, TimeUnit.SECONDS);
    }

    public void shutdown() {
        executorService.shutdown();
    }

}
