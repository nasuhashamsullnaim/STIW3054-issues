package my.issues.issue12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class OddThread extends Thread {
    int limit;
    sharedPrinter printer;
    private String OddNumber;

    public OddThread(int limit, sharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        int oddNumber = 1;
        while (oddNumber <= limit) {
            printer.printOdd(oddNumber);
            oddNumber = oddNumber + 2;
        }
    }
}

class EvenThread extends Thread {
    int limit;
    sharedPrinter printer;

    public EvenThread(int limit, sharedPrinter printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        int evenNumber = 2;
        while (evenNumber <= limit) {
            printer.printEven(evenNumber);
            evenNumber = evenNumber + 2;
        }
    }
}

class sharedPrinter {

    boolean isOddPrinted = false;

    synchronized void printOdd(int number) {

        while (isOddPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOddPrinted = true;
        File file = new File("MyNumber.txt");
        try {
            Thread.sleep(1000);

            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("\n" + Thread.currentThread().getName() + " : " + number);
            fileWriter.flush();
            fileWriter.close();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        notify();

        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
    }


    synchronized void printEven(int number) {
        while (!isOddPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOddPrinted = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}

public class OddNumberFile {
    public static void main(String[] args) {

        sharedPrinter printer = new sharedPrinter();
        OddThread oddThread = new OddThread(5, printer);
        oddThread.setName("Odd-Thread");
        EvenThread evenThread = new EvenThread(5, printer);
        evenThread.setName("Even-Thread");
        oddThread.start();
        evenThread.start();
    }
}