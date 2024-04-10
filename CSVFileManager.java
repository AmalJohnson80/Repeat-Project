// Name: Amal Johnson
// Student ID: 21263175

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class CSVFileManager {
    // Data field
    private String filePath;

    // Constructor
    public CSVFileManager(String filePath) {
        this.filePath = filePath;
    }

    // Reading information about the animals from the CSV File.
    public List<String[]> readData() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    // Writing information about the animals to the CSV File.
    public void writeData(List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] values : data) {
                writer.write(String.join(",", values));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

