
import java.sql.*;

import java.util.Scanner;


/**
 * Created by Kasia on 31.01.2017.
 */
public class LibrarySave {

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Book book = new Book();

            System.out.println("Podaj tytuł książki: ");
            book.setTitle(scan.nextLine());
            System.out.println("Podaj autora:");
            book.setAuthor(scan.nextLine());
            System.out.println("Podaj rok wydania:");
            book.setYear(scan.nextInt());
            scan.nextLine();
            System.out.println("ISBN książki:");
            book.setIsbn(scan.nextLine());


        BookDao dao = new BookDao();
        dao.save(book);

        }
        


    }

