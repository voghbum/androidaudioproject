package com.voghbum.androidaudiobookprojectbackend.data.repository;

import com.voghbum.androidaudiobookprojectbackend.data.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> searchAuthorByName(String name);
    Author findAuthorByName(String name);
}
