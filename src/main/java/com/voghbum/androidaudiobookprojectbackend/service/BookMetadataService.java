package com.voghbum.androidaudiobookprojectbackend.service;

import com.voghbum.androidaudiobookprojectbackend.data.dal.AudioBookServiceApplicationDal;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataRequestDTO;
import com.voghbum.androidaudiobookprojectbackend.mapper.BookMetadataMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static com.voghbum.androidaudiobookprojectbackend.data.util.DatabaseUtil.doWorkForService;

@Service
public class BookMetadataService {
    private final AudioBookServiceApplicationDal audioBookServiceApplicationDal;
    private final BookMetadataMapper bookMetadataMapper;

    public BookMetadataService(AudioBookServiceApplicationDal audioBookServiceApplicationDal, BookMetadataMapper bookMetadataMapper) {
        this.audioBookServiceApplicationDal = audioBookServiceApplicationDal;
        this.bookMetadataMapper = bookMetadataMapper;
    }

    public BookMetadataDTO saveBookMetadata(BookMetadataRequestDTO bookMetadataRequestDTO) {
        return doWorkForService(() -> {
            var bookMetadata = audioBookServiceApplicationDal.saveBookMetadata(bookMetadataMapper.toBookMetadata(bookMetadataRequestDTO));
            return bookMetadataMapper.toBookMetadataDTO(bookMetadata);
        }, "BookMetadataService.saveBookMetadata");
    }

    public List<BookMetadataDTO> findAllBookMetadata() {
        return doWorkForService(() -> {
            var it = audioBookServiceApplicationDal.findAllBookMetadata();
            return StreamSupport.stream(it.spliterator(), false)
                    .map(bookMetadataMapper::toBookMetadataDTO).toList();
        }, "BookMetadataService.findAllBookMetadata");
    }

    public List<BookMetadataDTO> searchBookMetadataByBookName(String name) {
        return doWorkForService(() -> {
            var it = audioBookServiceApplicationDal.searchBookMetadataByBookName(name);
            return StreamSupport.stream(it.spliterator(), false)
                    .map(bookMetadataMapper::toBookMetadataDTO).toList();
        }, "BookMetadataService.searchBookMetadataByBookName");
    }

}
