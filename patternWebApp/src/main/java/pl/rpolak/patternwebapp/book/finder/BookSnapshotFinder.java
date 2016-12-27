package pl.rpolak.patternwebapp.book.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.book.entity.Book;
import pl.rpolak.patternwebapp.book.repo.IBookRepository;
import pl.rpolak.patternwebapp.book.snapshot.BookSnapshot;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Component
public class BookSnapshotFinder implements IBookSnapshotFinder {

    private final IBookRepository bookRepository;

    @Autowired
    public BookSnapshotFinder(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookSnapshot findById(Long bookId) {
        Book book = bookRepository.findOne(bookId);
        return book == null ? null : book.toBookSnapshot();
    }

}
