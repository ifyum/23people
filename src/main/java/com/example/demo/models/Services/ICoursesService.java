package com.example.demo.models.Services;

import com.example.demo.models.entity.Courses;
import com.example.demo.models.Services.dto.CoursesDTO;

import java.util.List;

public interface ICoursesService {
    public List<Courses> findAll();

    public Courses findById(Long id);

//    public CoursesDTO save(CoursesDTO coursesDTO);

    public Courses save(Courses courses);

    public void delete(Long id);
}

