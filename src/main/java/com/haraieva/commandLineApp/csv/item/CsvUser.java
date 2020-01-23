package com.haraieva.commandLineApp.csv.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CsvUser {
    private Long id;
    private String name;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("city_id")
    private Long cityId;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
