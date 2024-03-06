package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFileRepository extends CrudRepository<BookFile, Long> {
}
