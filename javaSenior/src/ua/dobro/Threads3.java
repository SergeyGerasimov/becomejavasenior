package ua.dobro;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class Threads3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Please, enter waiting time for the second thread in s:");
        Scanner scan = new Scanner(System.in);
        long time = 0;
        time = scan.nextInt();
        if (time <= 0) {
            scan.close();
            throw new IllegalArgumentException("You entered zero or negative value " + time + "s");
        }
        if (time >= 60) {
            time = 60 * 1000;
        } else {
            time = time * 1000;
        }
        scan.close();
        Thread t1 = Thread.currentThread();
        Thread t2 = new Thread(new MessageLoopNew());
        printMessages.printMessage(t1, "Starting of the MessageLoop thread");
        printMessages.printMessage(t1, "Wait until the end of a second thread");
        t2.start();
        t2.join(time); // waiting for the 2-nd thread
        if (t2.isAlive()) {
            printMessages.printMessage(t1, "I won't wait any longer!");
        }
        t2.interrupt();
    }
}

class printMessages {
    public static void printMessage(Thread t, String message) {
        System.out.println(t.getName() + "        : " + message);
    }
}

class MessageLoopNew implements Runnable {
    private String[] messagesArray = { "First attempt", "Second attempt", "Third Attempt" };

    public void run() {
        for (String word : messagesArray) {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                System.out.println(currentThread().getName() + "    : The task has not been completed!!!");
                return;
            }
            System.out.println(currentThread().getName() + "    : " + word);
        }
        System.out.println(currentThread().getName() + "    : Task is completed!");
    }
}
