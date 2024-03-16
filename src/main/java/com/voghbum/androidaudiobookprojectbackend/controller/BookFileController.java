package com.voghbum.androidaudiobookprojectbackend.controller;

import com.voghbum.androidaudiobookprojectbackend.dto.BookFileAllDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileWithBodyDTO;
import com.voghbum.androidaudiobookprojectbackend.service.BookFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("prototype")
@RequestMapping("v1/api/bookFile")
public class BookFileController {
    private static final Logger LOG = LoggerFactory.getLogger(BookFileController.class);

    private final BookFileService bookFileService;

    public BookFileController(BookFileService authorService) {
        this.bookFileService = authorService;
    }
    @PostMapping("/save")
    public BookFileDTO saveBookFile(@RequestBody BookFileWithBodyDTO bookFileWithBodyDTO) {
        try {
            return bookFileService.saveBookFile(bookFileWithBodyDTO);
        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

    @GetMapping("/all")
    public List<BookFileDTO> findAllBookFiles() {
        try {
            return bookFileService.findAllBookFiles();
        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

    @GetMapping("/findById")
    public BookFileAllDTO findById(@RequestParam("id") long id) {
        try {
            return bookFileService.findBookFileById(id);
        } catch (Exception e) {
            LOG.error(e.toString());
            return null;
        }
    }

}
