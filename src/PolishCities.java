
import java.sql.*;

/**
 * Created by Kasia on 31.01.2017.
 */
public class PolishCities {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world";
        String username = "root";
        String password = "potter11";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM world.city\n" +
                "WHERE CountryCode = \"POL\";";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String CountryCode = resultSet.getString("CountryCode");
            String District = resultSet.getString("District");
            System.out.println(id + " " + name + " " + CountryCode + " " + District);
        }
    }// connection.close(); pamiętać o tym
}
