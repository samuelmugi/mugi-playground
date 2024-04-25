package com.codility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Sort {
    public static void sortFile(String readFilename, String writeFilename, String column) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(readFilename))) {
            String line;
            List<List<String>> rows = new ArrayList<>();
            while ((line = inputReader.readLine()) != null) {
                String[] fields = line.split(",");
                List<String> row = Arrays.asList(fields); // Simplified row creation
                rows.add(row);
            }

            int columnIndex = Integer.parseInt(column); // Fix to parse column index
            rows.sort(Comparator.comparing(row -> row.get(columnIndex))); // Fix to sort by given column

            try (FileWriter outputWriter = new FileWriter(writeFilename)) {
                for (List<String> row : rows) {
                    String joinedRow = String.join(",", row);
                    outputWriter.write(joinedRow + System.lineSeparator());
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid column index.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
