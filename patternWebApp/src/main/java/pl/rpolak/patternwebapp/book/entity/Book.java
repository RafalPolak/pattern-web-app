package pl.rpolak.patternwebapp.book.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import pl.rpolak.patternwebapp.book.snapshot.BookSnapshot;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(min = 5,
            max = 256)
    private String description;

    private Long quantity;

    private boolean isAvaliable;

    private Timestamp createdAt;

    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<Long> authors = new HashSet<>();

    protected Book() {
    }

    ;

    public Book(String title, String description, Long quantity) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.isAvaliable = true;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public void editBook(String title, String description, Long quantity) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    //change if book is avaliable or not
    public void unavaliable() {
        this.isAvaliable = false;
    }

    public void avaliable() {
        this.isAvaliable = true;
    }

    //add author to book
    public void addAuthorToBook(Long authorId) {
        this.authors.add(bookId);
    }
    
    //remove author from book
    public void removeAuthorFromBook(Long authorId){
        this.authors.remove(authorId);
    }

    public BookSnapshot toBookSnapshot() {
        return new BookSnapshot(bookId, title, description, quantity, isAvaliable, createdAt,
                Collections.unmodifiableSet(authors));
    }

}
