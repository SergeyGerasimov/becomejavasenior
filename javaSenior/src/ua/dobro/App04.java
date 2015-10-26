package ua.dobro;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App04 {
    public static void main(String[] args) {

    }
}

interface FileManagerNew {
    void makeCopyLambda(String inputFile, String outputFile);
}

interface PowerControl {
    boolean turnOnComputer();

    boolean turnOffComputer();
}

class OperationSystem implements FileManagerNew, PowerControl {
    public OperationSystem() {
    }

    public void makeCopyLambda(String inputFile, String outputFile) {
        if (inputFile == outputFile) {
            return;
        }
        try (Stream<String> input = Files.lines(Paths.get(inputFile));
                PrintWriter output = new PrintWriter(outputFile)) {
            input.forEach(output::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean turnOnComputer() {
        return false;
    }

    @Override
    public boolean turnOffComputer() {
        return false;
    }
}

class LaptopNew extends OperationSystem {
    private static final int DEFAULT_RAM_GB = 16;
    private static final double DEFAULT_CPU_GHz = 3.3;
    private static final String DEFAULT_laptopModel = "MacBookPro";
    private static final boolean DEFAULT_laptopState = false;
    private int RAM;
    private double CPU;
    private String laptopModel;
    private boolean laptopState;

    LaptopNew() {
        this(DEFAULT_RAM_GB, DEFAULT_CPU_GHz, DEFAULT_laptopModel, DEFAULT_laptopState);
    }

    LaptopNew(int RAM, double CPU, String laptopModel, boolean laptopState) {
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
        return "Laptop [RAM=" + RAM + ", CPU=" + CPU + ", laptopModel=" + laptopModel + ", laptopState="
                + laptopStateName + "]";
    }

}
