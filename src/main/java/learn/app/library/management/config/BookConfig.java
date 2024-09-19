package learn.app.library.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import learn.app.library.management.model.Book;

import java.util.HashSet;

@Configuration
public class BookConfig {

    @Bean
    public HashSet<Book> libraryBooks() {
        return new HashSet<>();
    }
}
