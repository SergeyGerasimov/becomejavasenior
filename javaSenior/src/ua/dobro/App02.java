package ua.dobro;

public class App02 {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        System.out.println(laptop.toString());
        laptop.setCPU(3.5);
        laptop.setLaptopModel("MacBookRetina");
        laptop.setRAM(32);
        System.out.println(laptop.getCPU());
        System.out.println(laptop.getLaptopModel());
        System.out.println(laptop.getRAM());
        System.out.println(laptop.isLaptopState());
        System.out.println(laptop);
    }

}

class Laptop {
    private static final int DEFAULT_RAM_GB = 16;
    private static final double DEFAULT_CPU_GHz = 3.3;
    private static final String DEFAULT_laptopModel = "MacBookPro";
    private static final boolean DEFAULT_laptopState = false;
    private int RAM;
    private double CPU;
    private String laptopModel;
    private boolean laptopState;

    Laptop() {
        this(DEFAULT_RAM_GB, DEFAULT_CPU_GHz, DEFAULT_laptopModel, DEFAULT_laptopState);
    }

    Laptop(int RAM, double CPU, String laptopModel, boolean laptopState) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.laptopModel = laptopModel;
        this.laptopState = laptopState;
    }

    /**
     * @return the rAM
     */
    public int getRAM() {
        return RAM;
    }

    /**
     * @param rAM
     *            the rAM to set
     */
    public void setRAM(int rAM) {
        RAM = rAM;
    }

    /**
     * @return the cPU
     */
    public double getCPU() {
        return CPU;
    }

    /**
     * @param cPU
     *            the cPU to set
     */
    public void setCPU(double cPU) {
        CPU = cPU;
    }

    /**
     * @return the laptopModel
     */
    public String getLaptopModel() {
        return laptopModel;
    }

    /**
     * @param laptopModel
     *            the laptopModel to set
     */
    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    /**
     * @return the laptopState
     */
    public boolean isLaptopState() {
        return laptopState;
    }

    /**
     * @param laptopState
     *            the laptopState to set
     */
    public void setLaptopState(boolean laptopState) {
        this.laptopState = laptopState;
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
