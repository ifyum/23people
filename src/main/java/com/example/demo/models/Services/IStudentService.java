package com.example.demo.models.Services;

import com.example.demo.models.Services.dto.StudentDTO;
import com.example.demo.models.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> findAll();

    public Student findById(Long id);

    public StudentDTO save(StudentDTO studentDTO);

    public void delete(Long id);
}
