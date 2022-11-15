package com.ust.student.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * The type Student.
 */
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

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
    private Set<Book> bookSet;


}