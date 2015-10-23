package ua.dobro;

import java.util.Map;
import java.util.TreeMap;

public class App01 {
    public static void main(String[] args) {
        String equipmentRAM = "RAMinMB";
        int ramSizeGB = 16;
        String equipmentCPU = "CPUinGHz";
        int cpuSpeedGHz = 3;
        String equipmentHardDrive = "HardDriveInGB";
        int hardDriveCapacityGB = 500;
        String equipmentVideoCard = "VideoCardinMB";
        int videoCardCapacityMB = 512;
        Map<String, Integer> equipmentList = new TreeMap<>();
        equipmentList.put(equipmentRAM, ramSizeGB);
        equipmentList.put(equipmentCPU, cpuSpeedGHz);
        equipmentList.put(equipmentHardDrive, hardDriveCapacityGB);
        equipmentList.put(equipmentVideoCard, videoCardCapacityMB);
        System.out.println(equipmentList);
    }
}