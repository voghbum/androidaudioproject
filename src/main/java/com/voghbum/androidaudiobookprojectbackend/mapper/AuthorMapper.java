package com.voghbum.androidaudiobookprojectbackend.mapper;

import com.voghbum.androidaudiobookprojectbackend.data.entity.Author;
import com.voghbum.androidaudiobookprojectbackend.dto.AuthorDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "AuthorMapperImpl", componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorDTO authorDTO);
    AuthorDTO toAuthorDTO(Author author);
}
