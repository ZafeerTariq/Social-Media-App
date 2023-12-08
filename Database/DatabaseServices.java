package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Models.Post;
import Models.User;
import Models.Object;
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

                SocialMedia.searchUserByID(
                    "u" + Integer.toString(id1)
                ).addFriend(
                    SocialMedia.searchUserByID("u" + Integer.toString(id2))
                );
                SocialMedia.searchUserByID(
                    "u" + Integer.toString(id2)
                ).addFriend(
                    SocialMedia.searchUserByID("u" + Integer.toString(id1))
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadPosts() {
        String query = "SELECT * FROM Post";
        try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("postID");
                Date posted = resultSet.getDate("postDate");
                String text = resultSet.getString("postText");
                int objId = resultSet.getInt("pageID");

                String objectID;
                if (resultSet.wasNull()) {
                    // if pageid is null then post must be made by a user
                    objId = resultSet.getInt("userID");
                    objectID = "u" + Integer.toString(objId);
                }
                else {
                    objectID = "p" + Integer.toString(objId);
                }

                Object poster = SocialMedia.searchObjectByID(objectID);
                Post post = new Post(id, text, poster, posted);
                poster.addPost(post);
            }
        } catch (SQLException e) {
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

    public User authenticate(String email, String password) {
        String query = "SELECT * FROM [User] WHERE email = (?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String pass = resultSet.getString("password");
                    int id = resultSet.getInt("userID");
                    if (pass.equals(password)) {
                        return SocialMedia.searchUserByID("u" + Integer.toString(id));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addPost(String objId, String text) {
        Object poster = SocialMedia.searchObjectByID(objId);

        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        String query = "";
        if (objId.charAt(0) == 'u') {
            //user posted
            query = "INSERT INTO Post (postDate, userID, postText) "
                    + "VALUES (?, ?, ?);";
        }
        else if (objId.charAt(0) == 'p') {
            //page posted
            query = "INSERT INTO Post (postDate, pageID, postText) "
                    + "VALUES (?, ?, ?);";
        }

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            int id = Integer.parseInt(objId.substring(1));

            statement.setDate(1, date);
            statement.setInt(2, id);
            statement.setString(3, text);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Posted successfully");
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println(generatedId);
                    Post post = new Post(generatedId, text, poster, date);
                    SocialMedia.posts.add(post);
                }
                return true;
            } else {
                System.out.println("Failed to insert user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void likePost(User user, Post post) {
        String query = "INSERT INTO [Like] (postID, userID) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            int uid = Integer.parseInt(user.getID().substring(1));

            statement.setInt(1, post.getID());
            statement.setInt(2, uid);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Post liked");
                post.addLike(user);
            }
            else {
                System.out.println("Could not like post");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}