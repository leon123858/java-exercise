import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    private static volatile ExecutorService executor;

    public static ExecutorService getInstance() {
        if(executor == null) {
            synchronized(ThreadPool.class)
            {
                if (executor == null) {
                    executor = Executors.newFixedThreadPool(DEFAULT_WORKER_NUMBERS);
                }
            }
        }
        return executor;
    }

    public static void shutdown() {
        if(executor != null) {
            synchronized(ThreadPool.class)
            {
                if (executor != null) {
                    executor.shutdown();
                }
            }
        }
    }

    public static void waitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        if(executor == null) {
            throw new InterruptedException("Thread pool not initialized");
        }
        if(executor.awaitTermination(timeout, unit)) {
            return;
        }
        throw new InterruptedException("Timeout waiting for thread pool termination");
    }
}
