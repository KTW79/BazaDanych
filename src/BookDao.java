

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Kasia on 31.01.2017.
 */
public class BookDao {

    public static final String URL = "jdbc:mysql://localhost:3306/library";
    public static final String USER = "root";
    public static final String PASS = "potter11";
    private Connection connection;


    public BookDao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) throws SQLException {
        Scanner scan = new Scanner(System.in);
        final String sql = "insert into books( title, author, year, isbn ) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3,book.getYear());
        preparedStatement.setString(4,book.getIsbn());
        preparedStatement.executeUpdate();
    }

    public Book readIsbn(String isbn) throws SQLException {
        final String sql = "select id, title, author, year, isbn from books where isbn = ?";
        PreparedStatement prepStmt = connection.prepareStatement(sql);
        prepStmt.setString(1,isbn);
        ResultSet result = prepStmt.executeQuery();
        if (result.next()) {
            Book book = new Book();
            book.setId(result.getInt(1));
            book.setTitle(result.getString(2));
            book.setAuthor(result.getString(3));
            book.setYear(result.getInt(4));
            book.setIsbn(result.getString(5));
            return book;
        }
        return null;
    }

    public Book read(int id) throws SQLException {
        final String sql = "select id, title, author, year, isbn from books where id = ?";
        PreparedStatement prepStmt = connection.prepareStatement(sql);
        prepStmt.setInt(1,id);
        ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getInt(1));
                book.setTitle(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setYear(result.getInt(4));
                book.setIsbn(result.getString(5));
                return book;
            }

        return null;
    }

    public void update(Book book) throws SQLException {
        final String sql = "update books set title = ?, author = ?, year = ?, isbn = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,book.getTitle());
        preparedStatement.setString(2,book.getAuthor());
        preparedStatement.setInt(3,book.getYear());
        preparedStatement.setString(4,book.getIsbn());
        preparedStatement.setInt(5,book.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        final String sql = "delete from books where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }
}



