package com.example.demo.models.Services;


import com.example.demo.models.Services.dto.StudentDTO;
import com.example.demo.models.Services.mapper.StudentMapper;
import com.example.demo.models.entity.Student;
import com.example.demo.models.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService{
    private final org.slf4j.Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
       return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Request to save courses : {}", studentDTO);

        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);

        return studentMapper.toDto(student);
    }

    @Override
    public void delete(Long id) {

    }


}
