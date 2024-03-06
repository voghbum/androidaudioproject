package com.voghbum.androidaudiobookprojectbackend.data.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Clob;

@Entity
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    public BookMetadata bookMetaData;
    @Lob
    @Column()
    public Blob bookAudio;
    @Lob
    @Column()
    public Clob bookText;
    @Column()
    public String language;
}
