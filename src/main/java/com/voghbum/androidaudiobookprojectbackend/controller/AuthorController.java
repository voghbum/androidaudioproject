package com.voghbum.androidaudiobookprojectbackend.controller;

import com.voghbum.androidaudiobookprojectbackend.dto.AuthorDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataDTO;
import com.voghbum.androidaudiobookprojectbackend.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("v1/api/author")
public class AuthorController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthorController.class);

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<AuthorDTO> findAllAuthors() {
        try {
            return authorService.findAllAuthors();
        } catch (Exception e) {
            LOG.error(e.toString());
            return new ArrayList<>();
        }
    }

    @GetMapping("/searchByName")
    public List<AuthorDTO> searchAuthorByName(@RequestParam("name") String name) {
        try {
            return authorService.searchAuthorByName(name);
        } catch (Exception e) {
            LOG.error(e.toString());
            throw e;
        }
    }

    @PostMapping("/save")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            return authorService.saveAuthor(authorDTO);
        } catch (Exception e) {
            LOG.error(e.toString());
            throw e;
        }
    }

}
