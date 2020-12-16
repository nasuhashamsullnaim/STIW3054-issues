package my.issues.issue16;

import java.util.concurrent.*;

public class maxNum implements Callable<Integer> {
    public static void main(String[] args) {
        Callable<Integer> maxNum = new maxNum();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(maxNum);

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
        int x = 0;
        int number = ThreadLocalRandom.current().nextInt(100);
        System.out.println("Number : " + number);
        for (int i = 0; i < number; i++) {
            System.out.println("Running : " + i);
            x = x + i;
        }
        return x;
    }
}
