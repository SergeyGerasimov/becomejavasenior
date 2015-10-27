package ua.dobro;

public class LaptopBrandnew {
    private static final int DEFAULT_RAM_GB = 16;
    private static final double DEFAULT_CPU_GHz = 3.3;
    private static final String DEFAULT_laptopModel = "MacBookPro";
    private static final boolean DEFAULT_laptopState = false;
    private int RAM;
    private double CPU;
    private String laptopModel;
    private boolean laptopState;
    private OSystem OSystem = null;

    LaptopBrandnew() {
        this(DEFAULT_RAM_GB, DEFAULT_CPU_GHz, DEFAULT_laptopModel, DEFAULT_laptopState);
    }

    LaptopBrandnew(int RAM, double CPU, String laptopModel, boolean laptopState) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.laptopModel = laptopModel;
        this.laptopState = laptopState;
    }

    public OSystem getOSystem() {
        return OSystem;
    }

    public void setOSystem(OSystem OSystem) {
        this.OSystem = OSystem;
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
        return "Laptop [RAM=" + RAM + ", CPU=" + CPU + ", laptopModel=" + laptopModel + ", laptopState="
                + laptopStateName + "]";
    }

    public static void main(String[] args) {
        LaptopBrandnew laptop = new LaptopBrandnew();
        laptop.setLaptopState(true);
        try {
            laptop.setOSystem(new OSystem(laptop));
        } catch (LaptopAccessException e){
            e.printStackTrace();
        }
        laptop.getOSystem().setFileManager(new FileManager(laptop));
        try {
            laptop.getOSystem().getFileManager().makeCopyLambda("first.txt", "second.txt");
        } catch (LaptopAccessException e) {
            e.printStackTrace();
        }
    }

}
