package CheakConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    static java.sql.Connection connection;
    static Statement statement;


    public static Connection connect(){

        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String userName = "project_database";
        String password = "123";

        try {
            Connection connection = DriverManager.getConnection(dbURL , userName , password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Ooops , There is error");
            e.printStackTrace();
        }
        return null;
    }
}
