package Pages;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {
    public static List<String[]> loadCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public Object[][] loadData(String fileName) {
        List<String[]> csvData = CSVLoader.loadCSV(fileName);
        Object[][] data = new Object[csvData.size()][2];

        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            data[i][0] = row[0];  // email
            data[i][1] = row[1];  // password

        }
        return data;
    }
    public Object[][] load_SignupData(String fileName) {
        List<String[]> csvData = CSVLoader.loadCSV("signup_data.csv");
        Object[][] data = new Object[csvData.size()][12];

        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            data[i][0] = row[0];  // username
            data[i][1] = row[1];  // password
            data[i][2] = row[2];  // days
            data[i][3] = row[3];  // moths
            data[i][4] = row[4];  // years
            data[i][5] = row[5];  // fname
            data[i][6] = row[6];  // lname
            data[i][7] = row[7];  // address
            data[i][8] = row[8];  // country
            data[i][9] = row[9];  // state
            data[i][10] = row[10];  // city
            data[i][11] = row[11];  // zip
        }
        return data;
    }
}
