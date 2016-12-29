package pl.rpolak.patternwebapp.author.finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.rpolak.patternwebapp.author.entity.Author;
import pl.rpolak.patternwebapp.author.repo.IAuthorRepository;
import pl.rpolak.patternwebapp.author.snapshot.AuthorSnapshot;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Component
public class AuthorSnapshotFinder implements IAuthorSnapshotFinder {

    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorSnapshotFinder(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorSnapshot findById(Long authorId) {
        Author author = authorRepository.findOne(authorId);
        return author == null ? null : author.toAuthorSnapshot();
    }

}
