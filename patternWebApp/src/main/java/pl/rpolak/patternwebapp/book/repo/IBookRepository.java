package pl.rpolak.patternwebapp.book.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.rpolak.patternwebapp.book.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

}
