package com.voghbum.androidaudiobookprojectbackend.data.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BookMetadata { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Author author;
    @Column(nullable = false, unique = true)
    public String name;
    @Column()
    public String description;
    @Column()
    public LocalDateTime writtenDateTime;
    @Column(nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();
    @Column(nullable = false)
    public LocalDateTime lastUpdate = insertDateTime;
    @Column(nullable = false)
    public boolean completed;
}

