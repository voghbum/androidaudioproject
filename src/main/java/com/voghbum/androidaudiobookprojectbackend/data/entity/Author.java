package com.voghbum.androidaudiobookprojectbackend.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;

    @Column(nullable = false, unique = true)
    public String name;

    @Lob
    @Column()
    public String description;

    @Column()
    public String location;

    @Column()
    public int bookCount;

    @Column()
    public LocalDate birthDate;
}
