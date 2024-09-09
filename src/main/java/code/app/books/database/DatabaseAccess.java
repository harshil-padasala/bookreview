package code.app.books.database;

import code.app.books.beans.Book;
import code.app.books.beans.Review;
import code.app.books.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public void insertBook(Book book) {
        String sql = "INSERT INTO book (title, author) VALUES (:title, :author)";

        Map<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("title", book.getTitle());
        params.put("author", book.getAuthor());

        jdbc.update(sql, params);
    }

    public void insertReview(Review review) {
        String sql = "INSERT INTO review (bookId, text) VALUES (:bookId, :text)";

        Map<String, Object> params = new HashMap<>();
        params.put("bookId", review.getBookId());
        params.put("text", review.getText());

        jdbc.update(sql, params);
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(Long id) {
        String sql = "SELECT * FROM book WHERE id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return jdbc.queryForObject(sql, params, new BeanPropertyRowMapper<>(Book.class));
    }

    public List<Review> getReviewsByBookId(Long id) {
        String sql = "SELECT * FROM review WHERE bookId = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return jdbc.query(sql, params, new BeanPropertyRowMapper<>(Review.class));
    }

    public void addUser(User user) {
        String sqlUser = "INSERT INTO users(username, password, enabled) VALUES (:username, :password, :enabled)";

        Map<String, Object> paramsUser = new HashMap<>();
        paramsUser.put("username", user.getUsername());
        paramsUser.put("password", "{noop}"+user.getPassword());
        paramsUser.put("enabled", 1);

        jdbc.update(sqlUser, paramsUser);

        String sqlAuthority = "INSERT INTO authorities(username, authority) VALUES (:username, :authority)";

        Map<String, Object> paramsAuthority = new HashMap<>();
        paramsAuthority.put("username", user.getUsername());
        paramsAuthority.put("authority", "ROLE_USER");

        jdbc.update(sqlAuthority, paramsAuthority);
    }
}
