package pl.rpolak.patternwebapp.book.finder;

import pl.rpolak.patternwebapp.book.snapshot.BookSnapshot;

public interface IBookSnapshotFinder {

    BookSnapshot findById(Long bookId);

}
