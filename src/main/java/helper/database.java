package helper;

public class database {
// Name of database file (contained in database folder)
protected static final String DATABASE = "jdbc:sqlite:database/ClimateChange.db";

    public static void main(String[] args) {
        createDatabase.create();
        System.out.println("Database created successfully!");
    }
}