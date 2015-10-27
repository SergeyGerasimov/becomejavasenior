package ua.dobro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.Stream;

class App03 {

    public static void main(String[] args) {
        Instant previous = Instant.now();
        FileManagerM.makeCopyLambda("first.txt", "second.txt");
        System.out.println(ChronoUnit.SECONDS.between(previous, Instant.now()) + " s");
    }
}

class FileManagerM {
    public FileManagerM() {
    }

    public static void makeCopy(String inputFile, String outputFile) {
        if (inputFile == outputFile) {
            return;
        }
        try {
            FileInputStream input = new FileInputStream(inputFile);
            FileOutputStream output = new FileOutputStream(outputFile);
            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeCopyLambda(String inputFile, String outputFile) {
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

    public static void makeCopyLambdaBuffer(String inputFile, String outputFile) {
        if (inputFile == outputFile) {
            return;
        }
        try (BufferedReader input = Files.newBufferedReader(Paths.get(inputFile));
                PrintWriter output = new PrintWriter(outputFile)) {
            input.lines().forEach(output::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeCopyScanner(String inputFile, String outputFile) {
        if (inputFile == outputFile) {
            return;
        }
        try (Scanner input = new Scanner(Paths.get(inputFile)); PrintWriter output = new PrintWriter(outputFile)) {
            while (input.hasNextLine()) {
                String currentLine = input.nextLine();
                for (int i = 0; i < currentLine.length(); i++) {
                    output.print(currentLine.charAt(i));
                }
                output.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
