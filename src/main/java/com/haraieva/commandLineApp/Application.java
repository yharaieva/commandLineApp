package com.haraieva.commandLineApp;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.haraieva.commandLineApp.csv.reader.CsvReader;
import com.haraieva.commandLineApp.repository.UserRepository;
import com.haraieva.commandLineApp.service.CityService;
import com.haraieva.commandLineApp.service.CountryService;
import com.haraieva.commandLineApp.service.UserService;
import org.apache.commons.cli.*;

public class Application {

    private static final String USER_FILE_PATH_PARAM = "userFile";
    private static final String CITY_FILE_PATH_PARAM = "cityFile";
    private static final String COUNTRY_FILE_PATH_PARAM = "countryFile";
    private static final String DB_URL_PARAM = "dbUrl";

    public static void main(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(buildOptions(), args);

        String userFilePath = cmd.getOptionValue(USER_FILE_PATH_PARAM);
        String cityFilePath = cmd.getOptionValue(CITY_FILE_PATH_PARAM);
        String countryFilePath = cmd.getOptionValue(COUNTRY_FILE_PATH_PARAM);
        String dbUrl = cmd.getOptionValue(DB_URL_PARAM);

        CsvMapper mapper = new CsvMapper();
        CsvReader reader = new CsvReader(mapper);

        CityService cityService = new CityService(reader, cityFilePath);
        CountryService countryService = new CountryService(reader, countryFilePath);

        UserRepository userRepository = new UserRepository(dbUrl);
        UserService userService = new UserService(reader, userRepository, userFilePath, cityService, countryService);

        userService.saveUsers();
    }

    private static Options buildOptions() {
        Options options = new Options();
        options.addOption(USER_FILE_PATH_PARAM, true, "A path to a CSV file with users");
        options.addOption(CITY_FILE_PATH_PARAM, true, "A path to a CSV file with cities");
        options.addOption(COUNTRY_FILE_PATH_PARAM, true, "A path to a CSV file with countries");
        options.addOption(DB_URL_PARAM, true, "URL for connection to MySQL");

        return options;
    }
}
