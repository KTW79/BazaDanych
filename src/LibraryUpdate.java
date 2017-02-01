import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Kasia on 01.02.2017.
 */
public class LibraryUpdate {
    public static void main(String[] args) throws SQLException {

        BookDao dao = new BookDao();
        Book book = dao.read(3);
        book.setTitle("Poradnik majstra budowlanego");
        dao.update(book);
        dao.close();
    }
}
