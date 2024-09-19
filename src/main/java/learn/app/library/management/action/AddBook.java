package learn.app.library.management.action;

import learn.app.library.management.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AddBook implements Action {

    private final HashSet<Book> books;

    public AddBook(final HashSet<Book> books) {
        this.books = books;
    }

    @Override
    public void perform(Book bookToAdd) {
        books.add(bookToAdd);
        System.out.println("Book added: " + bookToAdd.name());
    }
}
