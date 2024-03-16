package com.voghbum.androidaudiobookprojectbackend.data.dal;

import com.voghbum.androidaudiobookprojectbackend.data.entity.Author;
import com.voghbum.androidaudiobookprojectbackend.data.entity.BookFile;
import com.voghbum.androidaudiobookprojectbackend.data.entity.BookMetadata;
import com.voghbum.androidaudiobookprojectbackend.data.repository.AuthorRepository;
import com.voghbum.androidaudiobookprojectbackend.data.repository.BookFileRepository;
import com.voghbum.androidaudiobookprojectbackend.data.repository.BookMetaDataRepository;
import com.voghbum.androidaudiobookprojectbackend.data.util.RepositoryException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.voghbum.androidaudiobookprojectbackend.data.util.DatabaseUtil.doWorkForRepository;

@Component
public class AudioBookServiceApplicationDal {
    private AuthorRepository authorRepository;
    private BookMetaDataRepository bookMetaDataRepository;
    private BookFileRepository bookFileRepository;

    public AudioBookServiceApplicationDal(AuthorRepository authorRepository, BookMetaDataRepository bookMetaDataRepository, BookFileRepository bookFileRepository) {
        this.authorRepository = authorRepository;
        this.bookMetaDataRepository = bookMetaDataRepository;
        this.bookFileRepository = bookFileRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return doWorkForRepository(authorRepository::findAll, "AudioBookServiceApplicationDal.findAllAuthors");
    }

    public Author saveAuthor(Author author) {
        return doWorkForRepository(() -> authorRepository.save(author), "AudioBookServiceApplicationDal.saveAuthor");
    }

    public Iterable<Author> searchAuthorByName(String name) {
        return doWorkForRepository(() -> authorRepository.searchAuthorByName(name), "AudioBookServiceApplicationDal.searchAuthorByName");
    }

    public Iterable<BookMetadata> findAllBookMetadata() {
        return doWorkForRepository(() -> bookMetaDataRepository.findAll(), "AudioBookServiceApplicationDal.findAllBookMetadata");
    }

    public Iterable<BookMetadata> findAllBookMetadataByAuthorId(long authorId) {
        return doWorkForRepository(() -> bookMetaDataRepository.findAllByAuthorId(authorId), "AudioBookServiceApplicationDal.findAllBookMetadataByAuthorId");
    }

    public BookMetadata saveBookMetadata(BookMetadata bookMetadata) {
        return doWorkForRepository(() -> {
            var author = authorRepository.findAuthorByName(bookMetadata.author.name);
            if(author == null) {
                throw new RepositoryException("author cannot found with given name: " + bookMetadata.author.name);
            }
            bookMetadata.author = author;
            return bookMetaDataRepository.save(bookMetadata);
        }, "AudioBookServiceApplicationDal.saveBookMetadata");
    }

    public Iterable<BookMetadata> searchBookMetadataByBookName(String bookName) {
        return doWorkForRepository(() -> bookMetaDataRepository.searchBookMetadataByName(bookName), "AudioBookServiceApplicationDal.searchBookMetadataByBookName");
    }

    public Iterable<BookFile> findAllBookFileByBookMetadataId(long bookMetadataId) {
        return doWorkForRepository(() -> bookFileRepository.findAllByBookMetaData_Id(bookMetadataId), "AudioBookServiceApplicationDal.findAllBookMetadataByAuthorId");
    }

    public BookFile saveBookFile(BookFile bookFile) {
        return doWorkForRepository(() -> {
            return bookFileRepository.save(bookFile);
        }, "AudioBookServiceApplicationDal.saveBookFile");
    }

    public Iterable<BookFile> findAllBookFiles() {
        return doWorkForRepository(() -> bookFileRepository.findAll(), "AudioBookServiceApplicationDal.saveBookFile");
    }

    public Optional<BookFile> findBookFileById(long id) {
        return doWorkForRepository(() -> bookFileRepository.findById(id), "AudioBookServiceApplicationDal.saveBookFile");
    }
}
