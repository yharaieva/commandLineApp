package com.haraieva.commandLineApp.csv.reader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class CsvReader {

    private CsvMapper mapper;
    private CsvSchema schema;

    public CsvReader(CsvMapper mapper) {
        this.mapper = mapper;
        this.schema = CsvSchema.emptySchema().withHeader();
    }

    public <T> List<T> readItems(Class<T> itemType, String filePath) {
        System.out.println(String.format("Reading %s items from file %s", itemType, filePath));
        File file = new File(filePath);
        try {
            MappingIterator<T> items = mapper.readerFor(itemType).with(schema).readValues(file);
            return items.readAll();
        } catch (IOException e) {
            System.out.println(String.format("Unable to read file %s, %s", filePath, e.getMessage()));
            return Collections.emptyList();
        }
    }

}

