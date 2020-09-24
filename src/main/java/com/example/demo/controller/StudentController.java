package com.example.demo.controller;

import com.example.demo.controller.errors.BadRequestAlertException;
import com.example.demo.models.Services.IStudentService;
import com.example.demo.models.Services.RutValidator;
import com.example.demo.models.Services.StudentServiceImpl;
import com.example.demo.models.Services.dto.StudentDTO;
import com.example.demo.models.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    private static final String ENTITY_NAME = "Student";
    @Autowired
    private IStudentService studentService;

    @GetMapping( "/studentlist")
    public List<Student> listview (){ return studentService.findAll(); }


    @GetMapping("/student/{id}")
    public Student show(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/student")
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        log.debug("Controller Courses DTO : {}", student);
        if (RutValidator.validateRun(student.getRut()))
        {
          return  studentService.save(student);
        }
        else
        {
            throw new BadRequestAlertException("A Student invalid rut", ENTITY_NAME, "rut invalid");
        }

    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student update(@RequestBody Student courses) {
        return studentService.save(courses);
    }


    @DeleteMapping("/student/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void detele(@PathVariable Long id) {
        studentService.delete(id);
    }
}
