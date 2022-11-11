
package com.ust.student.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "book_ust_details_mappedby")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bookId;
    private String bookName;
    private String bookAuthorName;
    private int bookIsp;
    private LocalDateTime modifiedDate;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name= "student_id")
    Student student;


}



