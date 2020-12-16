package my.issues.issue10;

import java.util.Arrays;

public class meanModMedian {

    public static void main(String[] args) {

        new Thread(() -> { // Lambda Expression
            for (int i = 1; i <= 1; i++) {
                System.out.println("Main Thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        int[] dataSet = {224, 122, 116, 211, 123, 125};
        //MEAN
        int sum = 0;
        for (int n : dataSet) {
            sum += n;
        }
        new Thread(() -> { // Lambda Expression
            for (int i = 1; i <= 2; i++) {
                System.out.println("Thread 1 : " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("The mean of data set is :" + ((double) sum / dataSet.length));


        //MEDIAN
        new Thread(() -> { // Lambda Expression
            for (int i = 1; i <= 2; i++) {
                System.out.println("Thread 3 : " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Arrays.sort(dataSet);
        if (dataSet.length % 2 != 0) {
            System.out.println("The median of data set is : " + dataSet[dataSet.length / 2]);
        } else {
            System.out.println("The median of data set is : " + (dataSet[dataSet.length / 2] + dataSet[dataSet.length / 2 - 1] / 2.0));
        }

        //MODE
        new Thread(() -> { // Lambda Expression
            for (int i = 1; i <= 2; i++) {
                System.out.println("Thread 2 : " + i);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        int maxNum = -1;
        int maxAppreance = -1;
        for (int i = 0; i < dataSet.length; i++) {
            int count = 0;

            for (int j = 0; j < dataSet.length; j++) {
                if (dataSet[i] == dataSet[j])
                    count++;
            }
            if (count > maxAppreance) {
                maxNum = dataSet[i];
                maxAppreance = count;
            }
        }
        System.out.println("The mode of data set is : " + maxNum);
    }
}
