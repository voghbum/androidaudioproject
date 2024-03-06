package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
