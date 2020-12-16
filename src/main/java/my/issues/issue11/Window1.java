package my.issues.issue11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Window1 extends JFrame implements ActionListener {

    private JFrame f;
    private JButton b1;
    JLabel label1;

    public Window1() {
        b1 = new JButton("START");
        b1.setBounds(50, 50, 100, 40);
        add(b1);
        b1.addActionListener(this);

        //label1.setText("");

        setTitle("MEAN, MODE and MEDIAN");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == b1) {
            JOptionPane.showMessageDialog(this, "HELLO");
            new Thread(() -> { // Lambda Expression
                for (int i = 1; i <= 1; i++) {
                    JOptionPane.showMessageDialog(this, "Main Thread: " + i);
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

                new Thread(() -> { // Lambda Expression
                    for (int i = 1; i <= 2; i++) {
                        JOptionPane.showMessageDialog(this, "Thread 1 : " + i);
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                JOptionPane.showMessageDialog(this, "The mean of data set is :" + ((double) sum / dataSet.length));


                //MEDIAN
                new Thread(() -> { // Lambda Expression
                    for (int i = 1; i <= 2; i++) {
                        JOptionPane.showMessageDialog(this, "Thread 3 : " + i);
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Arrays.sort(dataSet);
                if (dataSet.length % 2 != 0) {
                    JOptionPane.showMessageDialog(this, "The median of data set is : " + dataSet[dataSet.length / 2]);
                } else {
                    JOptionPane.showMessageDialog(this, "The median of data set is : " + (dataSet[dataSet.length / 2] + dataSet[dataSet.length / 2 - 1] / 2.0));
                }

                //MODE
                new Thread(() -> { // Lambda Expression
                    for (int i = 1; i <= 2; i++) {
                        JOptionPane.showMessageDialog(this, "Thread 2 : " + i);
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
            }
        } else {
            JOptionPane.showMessageDialog(this, "BYE");
        }
    }


    public static void main(String[] args) {
        new Window1();


    }
}
