import java.sql.SQLException;

/**
 * Created by Kasia on 01.02.2017.
 */
public class LibraryDelete {
    public static void main(String[] args) throws SQLException {
        BookDao dao = new BookDao();
        dao.delete(5);
        dao.close();
    }
}
