package ru.job4j.tracker;

import jdbc.ConnectionRollback;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    public Connection init() {
        Connection connection = null;
        try (FileInputStream inputStream = new FileInputStream(
                "src/main/resources/app.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Test
    public void shouldAddItemIntoDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
           Item expected = sqlTracker.add(new Item("Bob"));
           Item result = sqlTracker.findById(expected.getId());
           assertThat(result, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReplaceItemsInDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
            Item before = sqlTracker.add(new Item("bob"));
            int id = before.getId();
            Item expected = new Item(id, "tom");
            sqlTracker.replace(id, new Item("tom"));
            Item result = sqlTracker.findById(id);
            assertThat(expected, is(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteItemFromDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
            Item first = sqlTracker.add(new Item("First"));
            int id = first.getId();
            sqlTracker.delete(id);
            assertThat(sqlTracker.findAll().isEmpty(), is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldFindAllItemsFromDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
            Item first = sqlTracker.add(new Item("first"));
            Item second = sqlTracker.add(new Item("second"));
            Item third = sqlTracker.add(new Item("third"));
            Item fourth = sqlTracker.add(new Item("fourth"));
            List<Item> expected = List.of(first, second, third, fourth);
            assertThat(expected, is(sqlTracker.findAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldFindByKeyItemFromDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
            Item bob = sqlTracker.add(new Item("bob"));
            Item tom = sqlTracker.add(new Item("tom"));
            Item bobTwo = sqlTracker.add(new Item("bob"));
            assertThat(List.of(bob, bobTwo), is(sqlTracker.findByKey("bob")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldFindByIdItemFromDB() {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(init()))) {
            Item bob = sqlTracker.add(new Item("bob"));
            Item tom = sqlTracker.add(new Item("tom"));
            int id = bob.getId();
            assertThat(bob, is(sqlTracker.findById(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}