package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookFile;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookFileRepository extends CrudRepository<BookFile, Long> {
    Iterable<BookFile> findAllByBookMetaData_Id(long bookMetadataId);
}
