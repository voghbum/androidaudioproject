package com.voghbum.androidaudiobookprojectbackend.data.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BookMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Author author;

    @Column(nullable = false, unique = true)
    public String name;

    @Lob
    @Column()
    public String description;

    @Column()
    public String writtenYear;

    @Column(nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();
}

