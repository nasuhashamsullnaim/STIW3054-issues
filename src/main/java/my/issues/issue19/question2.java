package my.issues.issue19;

import java.util.concurrent.*;

public class question2 implements Callable<Integer> {

    public static void main(String[] args) {

        Callable<Integer> multiplication = new my.issues.issue19.question2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(multiplication);

        try {
            Integer total = future.get();
            System.out.println("Total : " + total);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Failed!");
        }
        executorService.shutdown();
    }

    @Override
    public Integer call() throws Exception {
        int num = 1;
        int num1 = 2;
        int num2 = 3;
        int number = ThreadLocalRandom.current().nextInt(4);
        System.out.println("Number : " + number);

        for (int i = 1; i <= 3; ++i) {
            System.out.printf("Thread 0: %d * %d = %d \n", num, i, num * i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

        {
            for (int i = 1; i <= 3; ++i)
                System.out.printf("Thread 1: %d * %d = %d \n", num1, i, num1 * i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

        {
            for (int i = 1; i <= 3; ++i)
                System.out.printf("Thread 2: %d * %d = %d \n", num2, i, num2 * i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

        return num;
    }
}
