package com.example.demo.controller;

import com.example.demo.models.Services.CourseServiceImpl;
import com.example.demo.models.Services.ICoursesService;
import com.example.demo.models.Services.dto.CoursesDTO;
import com.example.demo.models.entity.Courses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursesController {

    private final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
    @Autowired
    private ICoursesService courseService;

        @GetMapping( "/courseslist")
    public List<Courses> listview (){ return courseService.findAll(); }


    @GetMapping("/courses/{id}")
    public Courses show(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public CoursesDTO create(@RequestBody CoursesDTO coursesDTO) {

        log.debug("Controller Courses DTO : {}", coursesDTO);

        return courseService.save(coursesDTO);
    }

}
