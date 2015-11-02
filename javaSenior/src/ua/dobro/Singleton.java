package ua.dobro;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Singleton {
    public static void main(String[] args) throws NoSuchFieldException {
        Thread t1 = new Thread(SingletonStatic.getInstance());
        t1.start();
        Class<?> myClass = t1.getClass();
        System.out.println(myClass);
        System.out.println(Arrays.toString(myClass.getInterfaces()));
        System.out.println(myClass.getTypeName());
        System.out.println(Modifier.toString(myClass.getModifiers()));
        System.out.println(Arrays.toString(myClass.getTypeParameters()));
        System.out.println(Arrays.toString(myClass.getAnnotations()));
        System.out.println(Arrays.toString(ua.dobro.SingletonStatic.class.getDeclaredFields()));
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
    private Integer reflection = 0;

    // private constructor
    private SingletonStatic() {
        reflection = 4;
    }

    // synchronized static factory
    public synchronized static SingletonStatic getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonStatic();
        }
        return INSTANCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SingletonStatic [reflection=" + reflection + "]";
    }

    public void run() {
        // System.out.println(getClass().getName() + " (threadsafe) is
        // running...");
    }
}
