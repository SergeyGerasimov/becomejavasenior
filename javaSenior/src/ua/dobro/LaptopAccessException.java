package ua.dobro;

public class LaptopAccessException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private String message;

    public LaptopAccessException (String message) {
        this.message = message;
    }
}
