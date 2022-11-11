package com.ust.student.service;

import com.ust.student.entity.Student;
import com.ust.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student getStudentByID(int id) {

        Student studentById=studentRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        getByName(studentById.getName());
        return studentById;


    }

    private void getByName(String name) {
        Student studentByName= studentRepository.findByName(name);
        System.out.printf("Student Name is >>>>>>        " + studentByName.getName() );
        System.out.printf("Student roll number is >>>>>>        " + studentByName.getRollNo() );
    }

    public void saveStudent(Student student) {
        student.setModifiedDate(LocalDateTime.now());
        student.setDate(LocalDateTime.now());
        studentRepository.save(student);

    }

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }



        public Student updateStudent(Student student){
            Student updateStudent=studentRepository.findById(student.getId()).orElseThrow(()->new NoSuchElementException());
            updateStudent.setName(student.getName());
            updateStudent.setRollNo(student.getRollNo());
            updateStudent.setModifiedDate(LocalDateTime.now());
            studentRepository.save(updateStudent);
            return updateStudent;
        }

    }





