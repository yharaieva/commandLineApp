package com.haraieva.commandLineApp.service;

import com.haraieva.commandLineApp.csv.item.CsvCity;
import com.haraieva.commandLineApp.csv.item.CsvUser;
import com.haraieva.commandLineApp.csv.reader.CsvReader;
import com.haraieva.commandLineApp.entity.User;
import com.haraieva.commandLineApp.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    private CsvReader reader;
    private UserRepository repository;
    private String userFilePath;
    private CityService cityService;
    private CountryService countryService;

    public UserService(CsvReader reader, UserRepository repository, String userFilePath, CityService cityService, CountryService countryService) {
        this.reader = reader;
        this.repository = repository;
        this.userFilePath = userFilePath;
        this.cityService = cityService;
        this.countryService = countryService;
    }

    public void saveUsers() {
        List<CsvUser> csvUsers = reader.readItems(CsvUser.class, userFilePath);
        Map<Long, CsvCity> cities = cityService.getCities();
        Map<Long, String> countryNames = countryService.getCountryNames();

        List<User> users = csvUsers.stream()
                .map(e -> convertCsvUserToEntity(e, cities, countryNames))
                .collect(Collectors.toList());

        repository.saveUsers(users);
    }

    private User convertCsvUserToEntity(CsvUser csvUser,
                                        Map<Long, CsvCity> cities,
                                        Map<Long, String> countryNames) {
        User user = new User();
        CsvCity city = cities.get(csvUser.getCityId());
        String countryName = countryNames.get(city.getCountryId());

        user.setId(csvUser.getId());
        user.setName(csvUser.getName());
        user.setDateOfBirth(csvUser.getDateOfBirth());
        user.setCity(city.getName());
        user.setCountry(countryName);

        return user;
    }
}
