package com.voghbum.androidaudiobookprojectbackend.data.entity;

import jakarta.persistence.*;

@Entity
public class BookFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "metadata_id", referencedColumnName = "id")
    public BookMetadata bookMetaData;

    @Lob
    @Column()
    public byte[] bookAudio;

    @Lob
    @Column()
    public String body;

    @Column()
    public String language;
}
