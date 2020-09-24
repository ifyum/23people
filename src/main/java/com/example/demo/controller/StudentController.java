package com.example.demo.controller;

import com.example.demo.models.Services.IStudentService;
import com.example.demo.models.Services.StudentServiceImpl;
import com.example.demo.models.Services.dto.StudentDTO;
import com.example.demo.models.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class StudentController {
    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private IStudentService studentService;

    @GetMapping( "/studentlist")
    public List<Student> listview (){ return studentService.findAll(); }


    @GetMapping("/student/{id}")
    public Student show(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO create(@RequestBody StudentDTO coursesDTO) {

        log.debug("Controller Courses DTO : {}", coursesDTO);

        return studentService.save(coursesDTO);
    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO update(@RequestBody StudentDTO coursesDTO) {
        return studentService.save(coursesDTO);
    }


    @DeleteMapping("/student/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void detele(@PathVariable Long id) {
        studentService.delete(id);
    }
}
