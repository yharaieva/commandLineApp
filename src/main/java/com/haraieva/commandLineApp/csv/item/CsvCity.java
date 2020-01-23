package com.haraieva.commandLineApp.csv.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CsvCity {
    private Long id;
    private String name;

    @JsonProperty("country_id")
    private Long countryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
