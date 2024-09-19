package learn.app.library.management.service;

import learn.app.library.management.action.Action;
import learn.app.library.management.exception.UnknownActionTypeException;
import learn.app.library.management.model.ActionType;
import learn.app.library.management.action.AddBook;
import learn.app.library.management.action.RemoveBook;
import learn.app.library.management.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final Map<ActionType, Action> actionTypeToAction;

    public BookService(List<Action> actions) {
        actionTypeToAction = new HashMap<>();
        for(Action action: actions) {
            if(action instanceof AddBook) {
                actionTypeToAction.put(ActionType.ADD_BOOK, action);
            } else if(action instanceof RemoveBook) {
                actionTypeToAction.put(ActionType.REMOVE_BOOK, action);
            }
        }
    }

    public void performAction(Book book, ActionType type) {
        Action action = actionTypeToAction.get(type);
        if(action != null) {
            action.perform(book);
        } else {
            throw new UnknownActionTypeException("Invalid ActionType" + type);
        }
    }
}
