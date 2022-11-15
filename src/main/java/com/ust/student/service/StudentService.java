package com.ust.student.service;


import com.ust.student.Exception.BusinessException;
import com.ust.student.Exception.InvalidEmail;
import com.ust.student.Exception.InvalidPassword;
import com.ust.student.Util.Util1;
import com.ust.student.dto.StudentDTO;
import com.ust.student.entity.Student;
import com.ust.student.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Student service.
 */
@Service
public class StudentService {

    /**
     * The Student repository.
     */
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Gets student by id.
     *
     * @param id the id
     * @return the student by id
     */
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

    /**
     * Save student.
     *
     * @param student the student
     */
    public void saveStudent(Student student) {
        student.setModifiedDate(LocalDateTime.now());
        student.setDate(LocalDateTime.now());
        String email =student.getEmail();
        String password = student.getPassword();

            int result = Util1.validateEmail(email);
            int result1 = Util1.validatePassword(password);
            if (result == 0 && result1==0) {
                student.setPassword(Util1.toHexString(Util1.getSHA(password)));
                studentRepository.save(student);
            }
        else if(result == 1){
            throw new InvalidEmail();
        } else  {
            throw new InvalidPassword();

            }


    }

    /**
     * Gets student all.
     *
     * @return the student all
     */
    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    /**
     * Delete student.
     *
     * @param id the id
     */
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }


    /**
     * Update student student.
     *
     * @param student the student
     * @return the student
     */
    public Student updateStudent(Student student){
            Student updateStudent=studentRepository.findById(student.getId()).orElseThrow(()->new NoSuchElementException());
            updateStudent.setName(student.getName());
            updateStudent.setRollNo(student.getRollNo());
            updateStudent.setModifiedDate(LocalDateTime.now());
            studentRepository.save(updateStudent);
            return updateStudent;
        }


    /**
     * Convert to dto student dto.
     *
     * @param student the student
     * @return the student dto
     */
    public StudentDTO convertToDTO(Student student) {
        return  modelMapper.map(student,StudentDTO.class);
    }
}





