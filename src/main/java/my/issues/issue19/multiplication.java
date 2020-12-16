package my.issues.issue19;

public class multiplication extends Exception {

    public static void main(String[] args) throws Exception {

        Thread t0 = new Thread(new Runnable() {
            int num = 1;

            @Override
            public void run() {
                for (int i = 1; i <= 3; ++i) {
                    System.out.printf("Thread 0: %d * %d = %d \n", num, i, num * i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        t0.start();
        t0.join();

        Thread t2 = new Thread(new Runnable() {
            int num2 = 3;

            @Override
            public void run() {
                for (int i = 1; i <= 3; ++i) {
                    System.out.printf("Thread 2: %d * %d = %d \n", num2, i, num2 * i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        t2.start();
        t2.join();

        Thread t1 = new Thread(new Runnable() {
            int num1 = 2;

            @Override
            public void run() {
                for (int i = 1; i <= 3; ++i) {
                    System.out.printf("Thread 1: %d * %d = %d \n", num1, i, num1 * i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
        t1.start();
        t1.join();
    }
}