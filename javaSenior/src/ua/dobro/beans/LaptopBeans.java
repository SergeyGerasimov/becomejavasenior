package ua.dobro.beans;

import java.io.Serializable;

public class LaptopBeans implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int RAM;
    private double CPU;
    private String laptopModel;
    private boolean laptopState;
    public LaptopBeans() {
    }
    /**
     * @return the rAM
     */
    public int getRAM() {
        return RAM;
    }
    /**
     * @param rAM the rAM to set
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
     * @param cPU the cPU to set
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
     * @param laptopModel the laptopModel to set
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
     * @param laptopState the laptopState to set
     */
    public void setLaptopState(boolean laptopState) {
        this.laptopState = laptopState;
    }
    
    
}
