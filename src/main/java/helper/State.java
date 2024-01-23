package helper;

import java.io.*;
import java.sql.*;
import java.util.Map;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class State {
    private static final String CSV_FILE = "database/GlobalYearlyLandTempByState.csv";

    static void StateTable(){
        try (Connection connection = DriverManager.getConnection(database.DATABASE)) {
            String query = "INSERT INTO StateTemperature (year,AVG_temp,Min_temp,Max_temp,state_name,country_code) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(CSV_FILE));
            // create Map object
            Map<String, String> line;
            int count = 0;

            while ((line = reader.readMap())!= null) {
                for (int year = 1960; year <= 2013; year++) {
                String year1 = line.get("Year");

                String averageTemperature = line.get("AverageTemperature");
                
                String minimumTemperature = line.get("MinimumTemperature");
                
                String maximumTemperature = line.get("MaximumTemperature");
                
                String state = line.get("state_name");
                //String country = line.get("country_code");
                if (averageTemperature != null && !averageTemperature.isEmpty()) {
                    statement.setDouble(2, Double.parseDouble(averageTemperature));
                } else {
                    statement.setObject(2, null);
                }
                if (minimumTemperature != null && !minimumTemperature.isEmpty()) {
                    statement.setDouble(3, Double.parseDouble(minimumTemperature));
                } else {
                    statement.setObject(3, null);
                }
                if (maximumTemperature != null && !maximumTemperature.isEmpty()) {
                    statement.setDouble(4, Double.parseDouble(maximumTemperature));
                } else {
                    statement.setObject(4, null);
                }
                System.out.println("Inserting " + year + " " + averageTemperature + " " + minimumTemperature + " " + maximumTemperature + " " + state + " " + "country" + " into State table...");
                statement.setString(1, year1);
                //statement.setString(2, averageTemperature);
                //statement.setString(3, minimumTemperature);
                //statement.setString(4, maximumTemperature);
                if (state != null && !state.isEmpty()) {
                    statement.setString(5, state);
                } else {
                    System.out.println("State is null or empty, cannot insert into database");
                    continue;
                }
                statement.setString(6, "WRD");
                statement.executeUpdate();
                ++count;
                System.out.println(statement);
                }
            }
            System.out.println("Inserted " + count);
            connection.close();

        }catch (SQLException | IOException | CsvValidationException e) {
                e.printStackTrace();
        }
    }
}