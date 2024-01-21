PRAGMA foreign_keys = OFF;
drop table if exists CountryTemperature;
drop table if exists CityTemperature;
drop table if exists StateTemperature;
drop table if exists Population;
drop table if exists Country;
drop table if exists WorldTemperature;
PRAGMA foreign_keys = ON;

CREATE TABLE Country(
    country_code      VARCHAR(3) PRIMARY KEY,
    country_name      VARCHAR(100) NOT NULL,
);

CREATE TABLE Population{
    pop_id            INTEGER PRIMARY KEY AUTOINCREMENT,
    country_code      VARCHAR(3) NOT NULL,
    year              INTEGER NOT NULL,
    pop_num           INTEGER,
    FOREIGN KEY (country_code) REFERENCES Country(country_code)
};

CREATE TABLE WorldTemperature{
    World_temp_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    AVG_temp         DECIMAL(5,2),
    MAX_temp         DECIMAL(5,2),
    MIN_temp         DECIMAL(5,2),
    L_O_AVG_temp     DECIMAL(5,2),
    L_O_MIN_temp    DECIMAL(5,2),
    L_O_MAX_temp    DECIMAL(5,2),
};


CREATE TABLE CountryTemperature{
    ctry_temp_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    country_code      VARCHAR(3) NOT NULL,
    year              INTEGER NOT NULL,
    AVG_temp              DECIMAL(5,2),
    MIN_temp              DECIMAL(5,2),
    MAX_temp              DECIMAL(5,2),
    FOREIGN KEY (country_code) REFERENCES Country(country_code),
};

CREATE TABLE StateTemperature{
    state_temp_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    state_code      VARCHAR(3) NOT NULL,
    year              INTEGER NOT NULL,
    AVG_temp              DECIMAL(5,2),
    MIN_temp              DECIMAL(5,2),
    MAX_temp              DECIMAL(5,2),
    FOREIGN KEY (state_code) REFERENCES State(state_code),
};

CREATE TABLE CityTemperature{
    city_temp_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    city_code      VARCHAR(3) NOT NULL,
    year              INTEGER NOT NULL,
    AVG_temp              DECIMAL(5,2),
    MIN_temp              DECIMAL(5,2),
    MAX_temp              DECIMAL(5,2),
    FOREIGN KEY (city_code) REFERENCES City(city_code),
}; 