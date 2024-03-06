package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMetaDataRepository extends CrudRepository<BookMetadata, Long> {
}
