package com.voghbum.androidaudiobookprojectbackend.mapper;

import com.voghbum.androidaudiobookprojectbackend.data.entity.BookMetadata;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataRequestDTO;
import com.voghbum.androidaudiobookprojectbackend.dto.BookMetadataWithAuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "BookMetadataMapperImpl", componentModel = "spring")
public interface BookMetadataMapper {
    @Mapping(target = "authorName", source = "bookMetadata.author.name")
    BookMetadataDTO toBookMetadataDTO(BookMetadata bookMetadata);
    @Mapping(target = "author.name", source = "bookMetadataDTO.authorName")
    BookMetadata toBookMetadata(BookMetadataDTO bookMetadataDTO);
    BookMetadataWithAuthorDTO toBookMetadataWithAuthorDTO(BookMetadata bookMetadata);
    @Mapping(target = "author.name", source = "bookMetadataRequestDTO.authorName")
    BookMetadata toBookMetadata(BookMetadataRequestDTO bookMetadataRequestDTO);
}
