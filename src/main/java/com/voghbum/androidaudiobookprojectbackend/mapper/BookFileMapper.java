package com.voghbum.androidaudiobookprojectbackend.mapper;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookFile;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileAllDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileWithAudioDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookFileWithBodyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "BookFileMapperImpl", componentModel = "spring")
public interface BookFileMapper {
    @Mapping(target = "bookMetaData.name", source = "name")
    BookFile toBookFile(BookFileDTO bookFileDTO);

    @Mapping(target = "name", source = "bookMetaData.name")
    BookFileDTO toBookFileDTO(BookFile bookFile);

    @Mapping(target = "bookMetaData.name", source = "name")
    BookFile toBookFile(BookFileWithBodyDTO bookFileDTO);

    @Mapping(target = "name", source = "bookMetaData.name")
    BookFileWithBodyDTO toBookFileWithBodyDTO(BookFile bookFile);

    @Mapping(target = "bookMetaData.name", source = "name")
    BookFile toBookFile(BookFileWithAudioDTO bookFileDTO);

    @Mapping(target = "name", source = "bookMetaData.name")
    BookFileWithAudioDTO toBookFileWithAudioDTO(BookFile bookFile);

    @Mapping(target = "bookMetaData.name", source = "name")
    BookFile toBookFile(BookFileAllDTO bookFileDTO);

    @Mapping(target = "name", source = "bookMetaData.name")
    BookFileAllDTO toBookFileAllDTO(BookFile bookFile);
}
