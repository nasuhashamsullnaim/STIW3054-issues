package my.issues.issue18;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Exam implements Runnable {
    private int id;
    CyclicBarrier cyclicBarrier;

    public Exam(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println(id + " starts the exam ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ID:" + id + " finished ...");
        try {
            cyclicBarrier.await();
            System.out.println("After study ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class cyclicBarrier {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("We will pass this exam ...");
                    }
                });
        for (int i = 0; i < 3; ++i) {
            executorService.execute(new Exam(i + 1, barrier));
        }
        executorService.shutdown();
    }
}