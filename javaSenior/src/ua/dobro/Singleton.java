package ua.dobro;

public class Singleton {

    public static void main(String[] args) {
        Thread t1 = new Thread(SingletonEnum.INSTANCE);
        Thread t2 = new Thread(SingletonStatic.getInstance());
        t1.start();
        t2.start();
    }

}

enum SingletonEnum implements Runnable {
    INSTANCE;
    public void run() {
        System.out.println(getClass().getName() + " (threadsafe) is running...");
    }
}

class SingletonStatic implements Runnable {
    private static SingletonStatic INSTANCE = null;

    // private constructor
    private SingletonStatic() {
    }

    // synchronized static factory
    public synchronized static SingletonStatic getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonStatic();
        }
        return INSTANCE;
    }

    public void run() {
        System.out.println(getClass().getName() + " (threadsafe) is running...");
    }
}
