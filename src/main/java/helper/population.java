package helper;

import java.io.*;
import java.sql.*;
import java.util.Map;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class population {
    private static final String CSV_FILE = "Population.csv";

    static void PopulationTable() {
        try (Connection connection = DriverManager.getConnection(database.DATABASE)) {
            // add table name, column name
            String query = "INSERT INTO Population (country_code, year, pop_num) VALUES ('?', '?', '?')";
            // name your statement
            PreparedStatement statement = connection.prepareStatement(query);

            // create CSVReader object
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(CSV_FILE));
            // create Map object
            Map<String, String> line;

            while ((line = reader.readMap()) != null) {
                for (int year = 1960; year <= 2013; year++) {

                }
            }
            connection.close();

        } catch (SQLException | IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
