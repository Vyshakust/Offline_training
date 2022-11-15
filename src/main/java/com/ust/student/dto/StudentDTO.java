package com.ust.student.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * The type Student dto.
 */
@Data
public class StudentDTO {
    private int id;
    private String name;
    private int rollNo;
}
