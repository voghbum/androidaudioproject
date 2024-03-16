package com.voghbum.androidaudiobookprojectbackend.service;

import com.voghbum.androidaudiobookprojectbackend.data.dal.AudioBookServiceApplicationDal;
import com.voghbum.androidaudiobookprojectbackend.data.entity.Author;
import com.voghbum.androidaudiobookprojectbackend.dto.AuthorDTO;
import com.voghbum.androidaudiobookprojectbackend.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static com.voghbum.androidaudiobookprojectbackend.data.util.DatabaseUtil.doWorkForService;

@Service
public class AuthorService {
    private final AudioBookServiceApplicationDal audioBookServiceApplicationDal;
    private final AuthorMapper authorMapper;

    public AuthorService(AudioBookServiceApplicationDal audioBookServiceApplicationDal, AuthorMapper authorMapper) {
        this.audioBookServiceApplicationDal = audioBookServiceApplicationDal;
        this.authorMapper = authorMapper;
    }

    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        return doWorkForService(() -> {
            Author author = audioBookServiceApplicationDal.saveAuthor(authorMapper.toAuthor(authorDTO));
            return authorMapper.toAuthorDTO(author);
        }, "AuthorService.saveAuthor");
    }

    public List<AuthorDTO> findAllAuthors() {
        return doWorkForService(() -> {
            Iterable<Author> authors = audioBookServiceApplicationDal.findAllAuthors();
            return StreamSupport.stream(authors.spliterator(), false).map(authorMapper::toAuthorDTO).toList();
        }, "AuthorService.findAllAuthors");
    }

    public List<AuthorDTO> searchAuthorByName(String name) {
        return doWorkForService(() -> {
            Iterable<Author> authors = audioBookServiceApplicationDal.searchAuthorByName(name);
            return StreamSupport.stream(authors.spliterator(), false).map(authorMapper::toAuthorDTO).toList();
        }, "AuthorService.searchAuthorByName");
    }
}
