package com.example.demo.controller;

import com.example.demo.models.Services.CoursesServiceImpl;
import com.example.demo.models.Services.ICoursesService;

import com.example.demo.models.entity.Courses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursesController {

    private final Logger log = LoggerFactory.getLogger(CoursesServiceImpl.class);
    @Autowired
    private ICoursesService courseService;

        @GetMapping( "/courseslist")
    public List<Courses> listview (){ return courseService.findAll(); }


    @GetMapping("/courses/{id}")
    public Courses show(@PathVariable Long id) {
        return courseService.findById(id);
    }



    @PostMapping("/courses")
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    public Courses create(@RequestBody Courses courses) {

        log.debug("Controller Courses DTO : {}", courses);

        return courseService.save(courses);
    }


    @PutMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Courses update(@RequestBody Courses courses) {
    return courseService.save(courses);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void detele(@PathVariable Long id) {
        courseService.delete(id);
    }
}
