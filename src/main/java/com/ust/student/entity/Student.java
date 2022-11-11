package com.ust.student.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "student_ustbatch_mappedby")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int rollNo;
    @OneToOne
    @JoinColumn(name="book_id")
    private Book book;

    private LocalDateTime modifiedDate;
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    private Set<Book> bookSet;

}