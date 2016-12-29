package pl.rpolak.patternwebapp.author.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;
import pl.rpolak.patternwebapp.author.snapshot.AuthorSnapshot;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    private Timestamp birthDate;

    private Timestamp deathDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<Long> address = new HashSet<>();

    protected Author() {

    }

    public Author(String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = Timestamp.valueOf(birthDate);
        this.deathDate = Timestamp.valueOf(deathDate);
    }

    public void editAuthor(String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = Timestamp.valueOf(birthDate);
        this.deathDate = Timestamp.valueOf(deathDate);
    }

    public void addAddresToAuthor(Long addressId) {
        this.address.add(addressId);
    }

    public void removeAddresFromAuthor(Long addressId) {
        this.address.remove(addressId);
    }

    public AuthorSnapshot toAuthorSnapshot() {
        return new AuthorSnapshot(authorId, name, surname, birthDate, deathDate);
    }

}
