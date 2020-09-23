package com.example.demo.models.services;

import com.example.demo.domain.Courses;
import com.example.demo.models.dto.CoursesDTO;

import java.util.List;

public interface ICoursesService {
    public List<Courses> findAll();

    public Courses findById(Long id);

    public CoursesDTO save(CoursesDTO clienteDTO);

    public void delete(Long id);
}

