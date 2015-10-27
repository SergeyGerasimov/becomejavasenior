package ua.dobro;

public class LaptopAccessException extends Exception {

    private static final long serialVersionUID = 1L;

    public LaptopAccessException (Throwable e) {
        initCause(e);
    }
}
