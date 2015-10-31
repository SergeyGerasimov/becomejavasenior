package ua.dobro;

public class Threads2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        Thread t2 = new Thread(new MessageLoop());
        System.out.println(t1.getName() + " : Starting of the MessageLoop thread");
        System.out.println(t1.getName() + " : Wait until the end of a second thread");
        t2.start();
        t2.join(1000);
        t2.interrupt();
        while (!t2.isInterrupted()) {
            System.out.println(t1.getName() + " : I'm waiting");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(t1.getName() + " : I won't wait any longer");
    }
}

