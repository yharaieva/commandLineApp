package com.haraieva.commandLineApp.repository;

import com.haraieva.commandLineApp.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepository {

    private static final String INSERT_QUERY = "INSERT INTO flat_users (id, name, date_of_birth, city_name, country_name) " +
            "VALUES (%d, '%s', '%s', '%s', '%s')";

    private String dbUrl;

    public UserRepository(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void saveUsers(List<User> users) {
        try (Connection connection = DriverManager.getConnection(dbUrl)) {
            Statement statement = connection.createStatement();

            for (User user : users) {
                String script = String.format(INSERT_QUERY,
                        user.getId(),
                        user.getName(),
                        user.getDateOfBirth(),
                        user.getCity(),
                        user.getCountry());
                statement.executeUpdate(script);
                System.out.println(String.format("User %s is saved to DB", user));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Unable to save users! %s", e.getMessage()));
        }
    }
}
