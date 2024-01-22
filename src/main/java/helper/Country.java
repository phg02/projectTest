package helper;

import java.io.*;
import java.sql.*;
import java.util.Map;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class Country {
    private static final String CSV_FILE = "database/Population.csv";

    static void countryTable() {
        try (Connection connection = DriverManager.getConnection(database.DATABASE)) {
            // add table name, column name
            String query = "INSERT INTO WorldTemperature (country_name, country_code) VALUES (?, ?)";
            // name your statement
            PreparedStatement statement = connection.prepareStatement(query);

            // create CSVReader object
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(CSV_FILE));
            // create Map object
            Map<String, String> line;

            while ((line = reader.readMap()) != null) {
                String country_name = line.get("country_name");
                String country_code = line.get("country_code");
                statement.setString(1, country_name);
                // remember to check null value by if statement
                // if (amount != null && !amount.isEmpty()) {
                // preparedStatement.setLong(3, Long.parseLong(amount));
                // } else{
                // preparedStatement.setObject(3, null);
                // }
                statement.setString(2, country_code);
                statement.executeUpdate();
                // insert count++ if you want to count how many rows are inserted
            }
            connection.close();

        } catch (SQLException | IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
