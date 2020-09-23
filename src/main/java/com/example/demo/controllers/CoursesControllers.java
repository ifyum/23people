package com.example.demo.controllers;
//import com.example.demo.models.services.CoursesService;
import com.example.demo.models.services.CoursesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoursesControllers {
    public  static final  String COURSES = "courses";
//    @Autowired
    //@Qualifier("coursesService")
    private CoursesServiceImpl coursesService;

    @GetMapping( "/courses")
    public String listview (Model model){
        model.addAttribute("courses", coursesService.findAll());
        return COURSES;
    }



}
