package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseServices {
    private String connectionString = "jdbc:sqlserver://DESKTOP-IM1NTKG\\SQLEXPRESS:1433;"
        + "database=socialMedia;"
        + "integratedSecurity=true;"
        + "encrypt=true;"
        + "trustServerCertificate=true;"
        + "loginTimeout=30;";

    private Connection connection;

    public DatabaseServices() {}

    public void initConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(connectionString);
            System.out.println("connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers() {
        String sql = "SELECT * FROM pokemon";
        try (PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Process the result set
                String column1Value = resultSet.getString("name");
                System.out.println(column1Value);
                // ... process other columns
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String fname, String lname, String email, String password, String contact, Date dob) {
        String query = "INSERT INTO \"User\" "
        + "(username, email, password, contact, dob) "
        + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fname + " " + lname);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, contact);
            statement.setDate(5, dob);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully");
                return true;
            } else {
                System.out.println("Failed to insert user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
