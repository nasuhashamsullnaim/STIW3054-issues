package my.issues.issue19;

import java.util.concurrent.TimeUnit;

public class question3 {

    public static void main(String args[]) {

        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in miliseconds : " + timeElapsed);
    }
}

