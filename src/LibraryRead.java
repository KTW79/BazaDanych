import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Kasia on 01.02.2017.
 */
public class LibraryRead {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj numer isbn: ");
        String isbn = scan.nextLine();

        BookDao dao = new BookDao();
        Book book = dao.readIsbn(isbn);
        System.out.println(book);
        dao.close();
    }
}
