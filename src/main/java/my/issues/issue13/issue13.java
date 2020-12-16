package my.issues.issue13;

class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }
}

public class issue13 {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++) {
                    c.increment();
                    if (i % 2 != 0) {
                        System.out.println("Thread 1 = " + i);

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }

        });
        t1.start();
        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 2; j <= 1000; j += 2) {
                    c.increment();
                    System.out.println("Thread 2 = " + j);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }

        });
        t2.start();
        t2.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 2; k <= 1000; k += 2) {
                    c.increment();
                    System.out.println("Thread 3 = " + k);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }

        });
        t3.start();
        t3.join();

        System.out.println("Count = " + c.count);
    }
}
