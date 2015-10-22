package ua.dobro;

public class App02 {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        System.out.println(laptop.GetState());
        laptop.TurnOn();
        System.out.println(laptop.GetState());
        laptop.TurnOff();
        System.out.println(laptop);
    }

}

class Laptop {
    private static final int DEFAULT_RAM_GB = 16;
    private static final double DEFAULT_CPU_GHz = 3.3;
    private static final String DEFAULT_laptopModel = "MacBookPro";
    private int RAM;
    private double CPU;
    private String laptopModel;
    private boolean laptopState = false;

    Laptop() {
        this(DEFAULT_RAM_GB, DEFAULT_CPU_GHz, DEFAULT_laptopModel);
    }

    Laptop(int RAM, double CPU, String laptopModel) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.laptopModel = laptopModel;
    }

    public void TurnOn() {
        laptopState = true;
    }
    
    public void TurnOff() {
        laptopState = false;
    }
    
    public String GetState() {
        return (laptopState) ? "TurnedOn" : "TurnedOff";
    }

    @Override
    public String toString() {
        String laptopStateName;
        if (laptopState) {
            laptopStateName = "TurnedOn";
        } else {
            laptopStateName = "TurnedOff";
        }
        return "Laptop [RAM=" + RAM + ", CPU=" + CPU + ", laptopModel="
                + laptopModel + ", laptopState=" + laptopStateName + "]";
    }

}
