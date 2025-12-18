package app.support.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import report.Report;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtils {

    public static String getDataFromCsv(String sheetName, int row, int col) {
        String filePath = calculatePath(sheetName);
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("CSV file not found: " + filePath);
            return "";
        }

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            List<String[]> r = reader.readAll();
            // Assuming row is 1-indexed in feature file but 0-indexed in list?
            // If the user passes '1', they likely mean the first data row (row 1).
            // But typically header is 0.
            // Let's assume the caller passes the correct 0-based index or we map it.
            // CommonsHooks logic is unknown, but Cucumber Examples often map to rows.
            // Let's assume strict index usage for now.
            if (row < r.size()) {
                String[] line = r.get(row);
                if (col < line.length) {
                    return line[col];
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return "";
    }

    public static void setResultInCsv(String filePath, int row, String result) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("CSV file not found for writing: " + filePath);
            return;
        }
        try {
            List<String[]> allElements;
            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                allElements = reader.readAll();
            }

            if (row < allElements.size()) {
                String[] line = allElements.get(row);
                String[] newLine = new String[line.length + 1];
                System.arraycopy(line, 0, newLine, 0, line.length);
                newLine[line.length] = result;
                allElements.set(row, newLine);
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
                writer.writeAll(allElements);
            }
        } catch (Exception e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static String calculatePath(String sheetName) {
        if (sheetName.endsWith(".csv"))
            return sheetName;
        // Default location logic
        return "src/test/resources/data/" + sheetName + ".csv";
    }
}
