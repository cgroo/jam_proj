package command_line;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EasyTimer {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void countdown(int seconds, Runnable actionOnCompletion) {
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

    public void shutdown() {
        executorService.shutdown();
    }

}
