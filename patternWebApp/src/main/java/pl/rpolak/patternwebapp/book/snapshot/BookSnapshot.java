package pl.rpolak.patternwebapp.book.snapshot;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

public class BookSnapshot {

    private final Long bookId;
    private final String title;
    private final String description;
    private final Long quantity;
    private final boolean isAvaliable;
    private final Timestamp createdAt;
    private final Set<Long> authors;

    public BookSnapshot(Long bookId, String title, String description, Long quantity, boolean isAvaliable, Timestamp createdAt, Set<Long> authors) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.isAvaliable = isAvaliable;
        this.createdAt = createdAt;
        this.authors = authors;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public boolean isIsAvaliable() {
        return isAvaliable;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Set<Long> getAuthors() {
        return authors;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.bookId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookSnapshot other = (BookSnapshot) obj;
        if (!Objects.equals(this.bookId, other.bookId)) {
            return false;
        }
        return true;
    }

    
    
}
