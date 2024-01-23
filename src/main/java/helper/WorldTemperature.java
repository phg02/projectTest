package helper;

import java.io.*;
import java.sql.*;
import java.util.Map;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class WorldTemperature {
    private static final String CSV_FILE = "database/GlobalYearlyTemp.csv";

    static void WorldTemperatureTable() {
        try (Connection connection = DriverManager.getConnection(database.DATABASE)) {
            // add table name, column name
            String query = "INSERT INTO WorldTemperature (country_code, AVG_temp, MAX_temp, MIN_temp, L_O_AVG_temp, L_O_MIN_temp, L_O_MAX_temp) VALUES (?, ?, ?,)";
            // name your statement
            PreparedStatement statement = connection.prepareStatement(query);

            // create CSVReader object
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(CSV_FILE));
        }
    }
}
