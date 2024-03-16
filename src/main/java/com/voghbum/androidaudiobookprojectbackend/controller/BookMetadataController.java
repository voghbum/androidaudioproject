package com.voghbum.androidaudiobookprojectbackend.controller;

import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataRequestDTO;
import com.voghbum.androidaudiobookprojectbackend.service.BookMetadataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("v1/api/bookMetaData")
public class BookMetadataController {
    private static final Logger LOG = LoggerFactory.getLogger(BookMetadataController.class);

    private final BookMetadataService bookMetadataService;

    public BookMetadataController(BookMetadataService bookMetadataService) {
        this.bookMetadataService = bookMetadataService;
    }

    @GetMapping("/all")
    public List<BookMetadataDTO> findAllBookMetadata() {
        try {
            return bookMetadataService.findAllBookMetadata();
        } catch (Exception e) {
            LOG.error(e.toString());
            return new ArrayList<>();
        }
    }

    @GetMapping("/searchByBookName")
    public List<BookMetadataDTO> searchBookMetadataByBookName(@RequestParam("name") String name) {
        try {
            return bookMetadataService.searchBookMetadataByBookName(name);
        } catch (Exception e) {
            LOG.error(e.toString());
            return new ArrayList<>();
        }
    }

    @PostMapping("/save")
    public BookMetadataDTO saveBookMetadata(@RequestBody BookMetadataRequestDTO bookMetadataRequestDTO) {
        try {
            return bookMetadataService.saveBookMetadata(bookMetadataRequestDTO);
        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }
}
