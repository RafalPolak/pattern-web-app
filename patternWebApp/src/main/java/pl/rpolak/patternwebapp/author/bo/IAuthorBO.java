package pl.rpolak.patternwebapp.author.bo;

import java.time.LocalDateTime;
import pl.rpolak.patternwebapp.author.snapshot.AuthorSnapshot;

public interface IAuthorBO {

    public AuthorSnapshot add(String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate);

    public AuthorSnapshot edit(Long authorId, String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate);

    public void delete(Long authorId);

    public void addAddresToAuthor(Long authorId, Long addressId);

    public void removeAddressFromAuthor(Long authorId, Long addresId);

}
