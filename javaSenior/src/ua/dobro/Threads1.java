package ua.dobro;

import static java.lang.Thread.*;

public class Threads1 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread(new MessageLoop());
        System.out.println(t1.getName() + " : Starting of the MessageLoop thread");
        t2.start();
        System.out.println(t1.getName() + " : Wait until the end of a second thread");
        while (t2.isAlive()) {
            System.out.println(t1.getName() + " : I'm waiting");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t1.getName() + " : The End");
    }
}

class MessageLoop implements Runnable {
    private String[] messagesArray = { "First attempt", "Second attempt", "Third Attempt" };

    public void run() {
        for (String word : messagesArray) {
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName() + " : " + word);
        }
    }
}
