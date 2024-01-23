package helper;

import java.util.Map;
import java.util.HashMap;

public class database {
    // Name of database file (contained in database folder)
    protected static final String DATABASE = "jdbc:sqlite:database/ClimateDB.db";

    public static void main(String[] args) {
        createDatabase.create();
        Country.countryTable();
        population.PopulationTable();
        System.out.println("Database created successfully!");
    }
}