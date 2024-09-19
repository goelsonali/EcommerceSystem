package learn.app.library.management.controller;

import learn.app.library.management.model.ActionType;
import learn.app.library.management.model.Book;
import learn.app.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        try {
            bookService.performAction(book, ActionType.ADD_BOOK);
            return ResponseEntity.ok("Book added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add book: " + e.getMessage());
        }
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeBook(@RequestBody Book book) {
        try {
            bookService.performAction(book, ActionType.REMOVE_BOOK);
            return ResponseEntity.ok("Book removed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove book: " + e.getMessage());
        }
    }
}
