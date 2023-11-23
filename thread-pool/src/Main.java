import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger tmp = new AtomicInteger();

        for(int i = 0; i < 100; i++) {
            // use thread pool to run the task in parallel for +1 on tmp
            ThreadPool.getInstance().submit(() -> {
                tmp.getAndIncrement();
                ThreadPool.getInstance().submit(() -> {
                    tmp.getAndIncrement();
                    ThreadPool.getInstance().submit(() -> {
                        tmp.getAndIncrement();
                        ThreadPool.getInstance().submit(() -> {
                            tmp.getAndIncrement();
                            ThreadPool.getInstance().submit(() -> {
                                tmp.getAndIncrement();
                            });
                        });
                    });
                });
            });
        }

        // print the value of tmp
        System.out.println("before wait: " + tmp.get());

        // shutdown the thread pool
        ThreadPool.shutdown();

        try {
            ThreadPool.waitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread pool did not terminate: " + e.getMessage());
        }

        // print the value of tmp
        System.out.println("after wait:" + tmp.get());
    }
}