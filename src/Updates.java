import java.sql.*;
import java.util.Scanner;

/**
 * Created by Kasia on 31.01.2017.
 */
public class Updates {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "potter11";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta:");
        String name = scan.nextLine();
        System.out.println("Podaj nową liczbę ludności:");
        int pplNumber = scan.nextInt();

        String query = "update city set Population = ? " +
                "WHERE Name = ?" ;
        PreparedStatement prepStmt = connection.prepareStatement(query);
        prepStmt.setString(2,name);
        prepStmt.setInt(1,pplNumber);
        int rows = prepStmt.executeUpdate();
        System.out.println(rows);


        query = "select id,Name,Population from city where and Name = ? ";
        PreparedStatement prepStmt1 = connection.prepareStatement(query);
        prepStmt1.setString(1,name);
        ResultSet resultSet1 = prepStmt1.executeQuery();
        resultSet1.next();
        System.out.println(resultSet1.getInt(1) + " " + resultSet1.getString(2));
        }


    }

