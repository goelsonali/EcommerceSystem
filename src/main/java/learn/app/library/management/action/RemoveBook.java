package learn.app.library.management.action;

import learn.app.library.management.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class RemoveBook implements Action {
    private HashSet<Book> books;

    public RemoveBook(HashSet<Book> books) {
        this.books = books;
    }

    @Override
    public void perform(Book book) {
        books.remove(book);
    }
}
