package ua.dobro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileManager {
    private LaptopBrandnew laptop;
    public FileManager(LaptopBrandnew laptop) {
        this.laptop = laptop;
    }
    public void makeCopyLambda(String inputFile, String outputFile) throws LaptopAccessException{
        if (!laptop.isLaptopState()) {
            throw new LaptopAccessException("Laptop is off");
        }
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
}
