package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private static final String URL = "jdbc:postgresql://localhost:5432/tracker_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    private static Properties loadPropertiesFile(String url) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(url)) {
            properties.load(inputStream);
            System.out.println("file was download");
        }
        return properties;
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL,
                loadPropertiesFile("src/main/resources/app.properties"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getUserName());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}
