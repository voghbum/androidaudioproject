package com.voghbum.androidaudiobookprojectbackend.service;

import com.voghbum.androidaudiobookprojectbackend.data.dal.AudioBookServiceApplicationDal;
import com.voghbum.androidaudiobookprojectbackend.data.entity.BookFile;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileAllDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileWithBodyDTO;
import com.voghbum.androidaudiobookprojectbackend.mapper.BookFileMapper;
import com.voghum.lib.service.TTSType;
import com.voghum.lib.service.TextToSpeechAPI;
import com.voghum.lib.service.TextToSpeechFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.StreamSupport;

import static com.voghbum.androidaudiobookprojectbackend.data.util.DatabaseUtil.doWorkForService;

@Service
public class BookFileService {
    private final BookFileMapper bookFileMapper;
    private final AudioBookServiceApplicationDal audioBookServiceApplicationDal;

    public BookFileService(BookFileMapper bookFileMapper, AudioBookServiceApplicationDal audioBookServiceApplicationDal) {
        this.bookFileMapper = bookFileMapper;
        this.audioBookServiceApplicationDal = audioBookServiceApplicationDal;
    }

    public BookFileDTO saveBookFile(BookFileWithBodyDTO bookFileDTO) {
        return doWorkForService(() -> {
            TextToSpeechAPI api = new TextToSpeechFactory().create(TTSType.OFFLINE);
            byte[] audio = api.get(bookFileDTO.getBody());
            var bookFileAll = new BookFileAllDTO();
            bookFileAll.setBody(bookFileDTO.getBody());
            bookFileAll.setLanguage(bookFileDTO.getLanguage());
            bookFileAll.setBookAudio(audio);
            bookFileAll.setName(bookFileDTO.getName());
            BookFile entity = bookFileMapper.toBookFile(bookFileAll);
            entity.bookMetaData = audioBookServiceApplicationDal.searchBookMetadataByBookName(bookFileAll.getName()).iterator().next();
            var persisted =  audioBookServiceApplicationDal.saveBookFile(entity);
            return bookFileMapper.toBookFileDTO(persisted);
        }, "BookFileService.saveBookFile");
    }

    public List<BookFileDTO> findAllBookFiles() {
        return doWorkForService(() -> {
            var it = audioBookServiceApplicationDal.findAllBookFiles();
            return StreamSupport.stream(it.spliterator(), false)
                    .map(bookFileMapper::toBookFileDTO).toList();
        }, "BookFileService.findAllBookFiles");
    }

    public BookFileAllDTO findBookFileById(long id) {
        return doWorkForService(() -> {
            var persisted = audioBookServiceApplicationDal.findBookFileById(id)
                    .orElseThrow(() -> new FileNotFoundException("BookFile cannot found"));
            return bookFileMapper.toBookFileAllDTO(persisted);
        }, "BookFileService.findAllBookFiles");
    }
}
