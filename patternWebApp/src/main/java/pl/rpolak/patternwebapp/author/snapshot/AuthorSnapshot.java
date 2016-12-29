package pl.rpolak.patternwebapp.author.snapshot;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class AuthorSnapshot {

    private final Long authorId;

    private final String name;

    private final String surname;

    private final LocalDateTime birthDate;

    private final LocalDateTime deathDate;

    public AuthorSnapshot(Long authorId, String name, String surname, Timestamp birthDate, Timestamp deathDate) {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate.toLocalDateTime();
        this.deathDate = deathDate.toLocalDateTime();
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getDeathDate() {
        return deathDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.authorId);
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
        final AuthorSnapshot other = (AuthorSnapshot) obj;
        if (!Objects.equals(this.authorId, other.authorId)) {
            return false;
        }
        return true;
    }

}
