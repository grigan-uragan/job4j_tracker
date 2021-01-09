package jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private String dumb;
    private Properties properties;

    public ImportDB(String dumb, Properties properties) {
        this.dumb = dumb;
        this.properties = properties;
    }

    public List<User> load() {
        List<User> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dumb))) {
           while (reader.ready()) {
               String string = reader.readLine();
               String[] strings = string.split(";");
               if (strings.length > 1) {
                   result.add(new User(strings[0], strings[1]));
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(List<User> users) {
        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("jdbc.url"),
                properties.getProperty("jdbc.user"),
                properties.getProperty("jdbc.password")
        )) {
            Class.forName(properties.getProperty("jdbc.driver"));
            for (User user : users) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "insert into spamer (name, email) values ((?), (?))")) {
                    statement.setString(1, user.getName());
                    statement.setString(2, user.getEmail());
                    statement.executeUpdate();
                }
            }

        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(
                "src/main/resources/spamer.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImportDB importDB = new ImportDB("dumb.txt", properties);
        List<User> users = importDB.load();
        importDB.save(users);
    }
}


