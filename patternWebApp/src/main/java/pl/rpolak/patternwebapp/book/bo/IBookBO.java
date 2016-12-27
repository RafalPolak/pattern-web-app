package pl.rpolak.patternwebapp.book.bo;

import java.util.List;
import pl.rpolak.patternwebapp.book.snapshot.BookSnapshot;

public interface IBookBO {

    public BookSnapshot add(String title, String description, Long quantity, List<Long> authors);

    public BookSnapshot edit(Long bookId, String title, String description, Long quantity);

    public void delete(Long bookId);
    
    public void addAuthorToBook(Long bookId, Long authorId);
    
    public void removeAuthorFromBook(Long bookId, Long authorId);

}
