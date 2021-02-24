package cz.osu.kip.mysqlTest;

import java.sql.*;

public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/test_mysql";
    private static String user = "root", passwd= "";


    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, passwd);

            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from person_test");

            while(resultSet.next()){
                int id = resultSet.getInt(2);
                String name = resultSet.getString(1);
                System.out.println(id + " " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
