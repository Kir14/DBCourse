package mysql;

import java.sql.*;

public class MySqlConnect {

    private Connection connection;

    public MySqlConnect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDB", "root", "mysql");
    }

    public ResultSet getUsersTable() throws SQLException {
        String query = "select * from users";
        return connection.createStatement().executeQuery(query);
    }

    public void addUser(String name, String email, int age) throws SQLException {
        String query = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        PreparedStatement prdStmt = connection.prepareStatement(query);
        prdStmt.setString(1, name);
        prdStmt.setString(2, email);
        prdStmt.setInt(3, age);
        prdStmt.executeUpdate();
    }

    public void updateById(int id, String name, String email, int age) throws SQLException {
        String updateQuery = "update users " +
                " set name =  ? , email = ? , age = ? " +
                " where id = ? ";
        PreparedStatement updStmt = connection.prepareStatement(updateQuery);
        updStmt.setString(1, name);
        updStmt.setString(2, email);
        updStmt.setInt(3, age);
        updStmt.setInt(4, id);
        updStmt.executeUpdate();
    }

    public void removeById(int id) throws SQLException {
        String deleteQuery = "delete from users where id = ? ";
        PreparedStatement dltStmt = connection.prepareStatement(deleteQuery);
        dltStmt.setInt(1, id);
        dltStmt.executeUpdate();
    }


}
