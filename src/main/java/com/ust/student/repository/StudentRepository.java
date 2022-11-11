package com.ust.student.repository;
import com.ust.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByName(String name);


}