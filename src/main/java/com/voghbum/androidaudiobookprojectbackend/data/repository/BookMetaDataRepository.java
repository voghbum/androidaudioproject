package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookMetadata;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookMetaDataRepository extends CrudRepository<BookMetadata, Long> {
    Iterable<BookMetadata> findAllByAuthorId(long authorId);
    Iterable<BookMetadata> searchBookMetadataByName(String bookName);
}
