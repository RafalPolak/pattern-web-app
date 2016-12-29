package pl.rpolak.patternwebapp.author.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.rpolak.patternwebapp.author.entity.Author;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByName(String name);

    List<Author> findBySurname(String surname);

    List<Author> findByNameAndSurname(String name, String surname);

}
