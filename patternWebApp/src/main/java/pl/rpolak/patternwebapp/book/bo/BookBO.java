package pl.rpolak.patternwebapp.book.bo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.book.entity.Book;
import pl.rpolak.patternwebapp.book.repo.IBookRepository;
import pl.rpolak.patternwebapp.book.snapshot.BookSnapshot;

@Service
@Transactional
public class BookBO implements IBookBO {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookBO.class);

    private final IBookRepository bookRepository;

    @Autowired
    public BookBO(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookSnapshot add(String title, String description, Long quantity, List<Long> authors) {

        Book book = new Book(title, description, quantity);

        authors.stream().forEach((authorId) -> {
            book.addAuthorToBook(authorId);
        });

        bookRepository.save(book);

        BookSnapshot bookSnapshot = book.toBookSnapshot();

        LOGGER.info("Add new book <{}> <{}> <{}> <{}>",
                bookSnapshot.getTitle(),
                bookSnapshot.getDescription(),
                bookSnapshot.getQuantity(),
                bookSnapshot.getAuthors());

        return bookSnapshot;

    }

    @Override
    public BookSnapshot edit(Long bookId, String title, String description, Long quantity) {

        Book book = bookRepository.findOne(bookId);

        book.editBook(title, description, quantity);

        bookRepository.save(book);

        BookSnapshot bookSnapshot = book.toBookSnapshot();

        LOGGER.info("Edit book <{}> <{}>", bookId, title);

        return bookSnapshot;
    }

    @Override
    public void delete(Long bookId) {
        Book book = bookRepository.findOne(bookId);

        bookRepository.delete(book);

        LOGGER.info("Remove book <{}>", bookId);
    }

    @Override
    public void addAuthorToBook(Long bookId, Long authorId) {
        Book book = bookRepository.findOne(bookId);

        book.addAuthorToBook(authorId);

        bookRepository.save(book);

        LOGGER.info("Add author to book <{}> <{}>", authorId, bookId);
    }

    @Override
    public void removeAuthorFromBook(Long bookId, Long authorId) {
        Book book = bookRepository.findOne(bookId);

        book.removeAuthorFromBook(authorId);

        bookRepository.save(book);

        LOGGER.info("Remove author from book <{}> <{}>", authorId, bookId);
    }

}
