package ua.dobro;

public class Threads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread1());
        Thread thread2 = new MyThread2();
        System.out.println("Walking");
        thread1.start();
        thread2.start();
    }
}

class MyThread1 implements Runnable {
    public void run() {
        System.out.println("Running");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Flying");
    }

}
