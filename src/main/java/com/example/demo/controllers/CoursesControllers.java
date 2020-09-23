package com.example.demo.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursesControllers {
	 @GetMapping(value="/courses")
	 public String courses() {
		
		return "courses";
	 }

}
