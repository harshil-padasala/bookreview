package code.app.books.beans;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private Long bookId;
    private String text;
}
