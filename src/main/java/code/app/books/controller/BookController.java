package code.app.books.controller;

import code.app.books.beans.Book;
import code.app.books.beans.Review;
import code.app.books.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping()
    public String showBooks(Model model) {
        // Get all books from the database
        List<Book> books = databaseAccess.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
        // Add books to the model for rendering in the HTML template
        model.addAttribute("books", books);

        return "index";
    }

    @GetMapping("/reviews/{id}")
    public String showBooksReviewByBookId(@PathVariable Long id, Model model) {
        // Get all reviews by bookId
        List<Review> reviews = databaseAccess.getReviewsByBookId(id);

        // Add Book and Book's Review to the model attribute
        model.addAttribute("book", databaseAccess.getBookById(id));
        model.addAttribute("reviews", reviews);

        return "view-book";

    }

    @GetMapping("/showAddBookForm")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "/admin/add-book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        databaseAccess.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/showAddReviewForm")
    public String showAddReviewForm(@RequestParam Long bookId, Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("bookId", bookId);
        return "/user/add-review";
    }

    @PostMapping("/addReview")
    public String addReview(@ModelAttribute Review review) {
        databaseAccess.insertReview(review);
        return "redirect:/books";
    }
}
