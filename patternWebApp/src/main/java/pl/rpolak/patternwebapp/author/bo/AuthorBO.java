package pl.rpolak.patternwebapp.author.bo;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.author.entity.Author;
import pl.rpolak.patternwebapp.author.repo.IAuthorRepository;
import pl.rpolak.patternwebapp.author.snapshot.AuthorSnapshot;

@Service
@Transactional
public class AuthorBO implements IAuthorBO {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorBO.class);

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorBO(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorSnapshot add(String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate) {
        Author author = new Author(name, surname, birthDate, deathDate);

        authorRepository.save(author);

        AuthorSnapshot authorSnapshot = author.toAuthorSnapshot();

        LOGGER.info("Add Author <{}> <{}> <{}> <{}>",
                authorSnapshot.getName(),
                authorSnapshot.getSurname(),
                authorSnapshot.getBirthDate(),
                authorSnapshot.getDeathDate());
        return authorSnapshot;
    }

    @Override
    public AuthorSnapshot edit(Long authorId, String name, String surname, LocalDateTime birthDate, LocalDateTime deathDate) {
        Author author = authorRepository.findOne(authorId);

        author.editAuthor(name, surname, birthDate, deathDate);

        authorRepository.save(author);

        AuthorSnapshot authorSnapshot = author.toAuthorSnapshot();

        LOGGER.info("Edit Author <{}> <{}>",
                authorSnapshot.getName(),
                authorSnapshot.getSurname());

        return authorSnapshot;
    }

    @Override
    public void delete(Long authorId) {
        Author author = authorRepository.findOne(authorId);

        authorRepository.delete(author);

        LOGGER.info("Delete Author <{}>", authorId);
    }

    @Override
    public void addAddresToAuthor(Long authorId, Long addressId) {
        Author author = authorRepository.findOne(authorId);

        author.addAddresToAuthor(addressId);

        authorRepository.save(author);

        LOGGER.info("Add Address to Author <{}> <{}>",
                addressId, authorId);
    }

    @Override
    public void removeAddressFromAuthor(Long authorId, Long addresId) {
        Author author = authorRepository.findOne(authorId);

        author.removeAddresFromAuthor(addresId);

        authorRepository.save(author);

        LOGGER.info("Remove Address from Author <{}> <{}>",
                addresId, authorId);

    }

}
