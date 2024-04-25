package com.codility;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class RemoveDuplicate {
    public static void removeDuplicate(String readFilename, String writeFilename, String column) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(readFilename))) {
            String line;
            Set<List<String>> uniqueRows = new HashSet<>(); // Fix to use Set for efficient duplicate removal
            while ((line = inputReader.readLine()) != null) {
                String[] fields = line.split(",");
                List<String> row = Arrays.asList(fields); // Simplified row creation
                uniqueRows.add(row);
            }
            try (FileWriter outputWriter = new FileWriter(writeFilename)) {
                for (List<String> row : uniqueRows) {
                    String joinedRow = String.join(",", row);
                    outputWriter.write(joinedRow + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}