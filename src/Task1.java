import java.util.concurrent.TimeUnit;

public class Task1 {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            while (flag) {
                long currentTime = getCurrentTime(startTime);
                if (currentTime % 5 != 0) {
                    System.out.println(currentTime + " секунда.");
                }
                if (currentTime == 11) {
                    flag = false;
                }
                sleep(1);
            }
        });

        Thread thread1 = new Thread(() -> {
            while (flag) {
                long currentTime = getCurrentTime(startTime);
                if (currentTime % 5 == 0) {
                    System.out.println("Минуло " + currentTime + " секунд.");
                }
                if (currentTime == 10) {
                    flag = false;
                }
                sleep(1);
            }
        });

        thread.start();
        thread1.start();
    }

    private static long getCurrentTime(long startTime) {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}