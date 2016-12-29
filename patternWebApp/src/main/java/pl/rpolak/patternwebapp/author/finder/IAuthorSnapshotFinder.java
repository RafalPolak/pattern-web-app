package pl.rpolak.patternwebapp.author.finder;

import pl.rpolak.patternwebapp.author.snapshot.AuthorSnapshot;

public interface IAuthorSnapshotFinder {

    AuthorSnapshot findById(Long authorId);

}
