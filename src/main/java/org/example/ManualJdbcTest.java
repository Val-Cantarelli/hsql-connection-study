package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManualJdbcTest {
    public static void main(String[] args) {
        // db memo credentials
        String url = "jdbc:hsqldb:mem:testdb";
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected successful!");

            // create table
            stmt.execute("CREATE TABLE study (id INT, name VARCHAR(50))");
            System.out.println(">>> 2. Table 'study' created.");

            //insert data
            stmt.executeUpdate("INSERT INTO study VALUES (1, 'My first Pool')");
            System.out.println(">>> 3. Data added.");

            // query
            System.out.println(">>> 4. Selecting data:");
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM study")) {
                while (rs.next()) {

                    // Retrieve att the values from column "name"
                    String columnName = rs.getString("name");
                    System.out.println("   - Founded: " + columnName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}