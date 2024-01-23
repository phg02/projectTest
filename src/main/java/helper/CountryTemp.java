package helper;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class CountryTemp {
    private static final String CSV_FILE = "database/GlobalYearlyLandTempByCountry.csv";

    static void CountryTempTable() {
        try (Connection connection = DriverManager.getConnection(database.DATABASE)) {
            String query = "INSERT INTO CountryTemperature (country_code, year, AVG_temp, MIN_temp, MAX_temp) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // create CSVReader object
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(CSV_FILE));
            // create Map object

            Map<String, String> line;

            int count = 0;

            while ((line = reader.readMap()) != null) {
                String countryCode = "USA"; // Need help here(method to get country code from country.csv)

                String year = line.get("Year");

                String avgTemp = line.get("AverageTemperature");

                String minTemp = line.get("MinTemperature");

                String maxTemp = line.get("MaxTemperature");

                statement.setString(1, countryCode);
                // remember to check null value by if statement
                // if (amount != null && !amount.isEmpty()) {
                // preparedStatement.setLong(3, Long.parseLong(amount));
                // } else{
                // preparedStatement.setObject(3, null);
                // }
                statement.setString(2, year);
                statement.setString(3, avgTemp);
                statement.setString(4, minTemp);
                statement.setString(5, maxTemp);
                statement.executeUpdate();
                // insert count++ if you want to count how many rows are inserted
                ++count;
            }
            System.out.println("Inserted " + count);
            connection.close();

        } catch (SQLException | IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
