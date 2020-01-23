package com.haraieva.commandLineApp.service;

import com.haraieva.commandLineApp.csv.item.CsvCountry;
import com.haraieva.commandLineApp.csv.reader.CsvReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryService {

    private CsvReader csvReader;
    private String countryFilePath;

    public CountryService(CsvReader csvReader, String countryFilePath) {
        this.csvReader = csvReader;
        this.countryFilePath = countryFilePath;
    }

    public Map<Long, String> getCountryNames() {
        List<CsvCountry> cities = csvReader.readItems(CsvCountry.class, countryFilePath);
        return cities.stream()
                .collect(Collectors.toMap(CsvCountry::getId, CsvCountry::getName));
    }
}
