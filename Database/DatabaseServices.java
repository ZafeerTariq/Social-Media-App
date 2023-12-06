package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.User;
import main.SocialMedia;

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
        String query = "SELECT * FROM \"USER\"";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("userID");
                String fname = resultSet.getString("first_name");
                String lname = resultSet.getString("last_name");
                String username = resultSet.getString("username");
                String bio = resultSet.getString("bio");
                String contact = resultSet.getString("contact");
                String city = resultSet.getString("city");
                Date dob = resultSet.getDate("dob");

                SocialMedia.users.add(new User(id,username, fname, lname, bio, contact, dob, city));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        query = "SELECT * FROM friendship";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id1 = resultSet.getInt("userID1");
                int id2 = resultSet.getInt("userID2");

                SocialMedia.searchUserByID(id1).addFriend(SocialMedia.searchUserByID(id2));
                SocialMedia.searchUserByID(id2).addFriend(SocialMedia.searchUserByID(id1));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(String fname, String lname, String email, String password, String contact, Date dob) {
        String query = "INSERT INTO \"User\" "
        + "(first_name, last_name, email, password, contact, dob) "
        + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, contact);
            statement.setDate(6, dob);

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
