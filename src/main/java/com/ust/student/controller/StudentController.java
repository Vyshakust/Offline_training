package com.ust.student.controller;
import com.ust.student.Exception.BusinessException;
import com.ust.student.Util.Util1;
import com.ust.student.dto.StudentDTO;
import com.ust.student.entity.Student;
import com.ust.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Student controller.
 */
@RestController
public class StudentController {

    /**
     * The Student service.
     */
    @Autowired
    StudentService studentService;

    /**
     * Get response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO>get(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentByID(id);
            student.setEmail(" ");
            student.setPassword(" ");
            return new ResponseEntity<StudentDTO>(studentService.convertToDTO(student), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get request response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/student")
    public ResponseEntity<Student>getRequest(@RequestParam(name="id") Integer id) {
        try {
            Student student = studentService.getStudentByID(id);

            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get 2 response entity.
     *
     * @return the response entity
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> get2(){
        try {

            List<Student> studentList=studentService.getStudentAll();
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add 2.
     *
     * @param student the student
     */
    @PostMapping("/students")
    public void add2(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    /**
     * Update student.
     *
     * @param student the student
     */
    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    /**
     * Add response entity.
     *
     * @param student the student
     * @return the response entity
     */
    @PostMapping("/student")
    public ResponseEntity<Student> add(@RequestBody Student student){


        try {





                studentService.saveStudent(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);


        }
        catch(BusinessException e){
            return new ResponseEntity<Student>(HttpStatus.PRECONDITION_FAILED);
        }
    }


}