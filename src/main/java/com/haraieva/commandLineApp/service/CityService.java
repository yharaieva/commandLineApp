package com.haraieva.commandLineApp.service;

import com.haraieva.commandLineApp.csv.item.CsvCity;
import com.haraieva.commandLineApp.csv.reader.CsvReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityService {

    private CsvReader csvReader;
    private String cityFilePath;

    public CityService(CsvReader csvReader, String cityFilePath) {
        this.csvReader = csvReader;
        this.cityFilePath = cityFilePath;
    }

    public Map<Long, CsvCity> getCities() {
        List<CsvCity> cities = csvReader.readItems(CsvCity.class, cityFilePath);
        return cities.stream()
                .collect(Collectors.toMap(CsvCity::getId, e -> e));
    }
}
