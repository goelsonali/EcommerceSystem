package learn.app.library.management.action;

import learn.app.library.management.model.Book;

public interface Action {

    void perform(Book book);
}
