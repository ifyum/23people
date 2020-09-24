package com.example.demo.models.Services;


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
    private final Logger log= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;
    private String runSolicitante;
//    @Autowired
//    private StudentMapper studentMapper;


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
    public Student save(Student student) {
        log.debug("Request to save courses : {}", student);


         log.debug("back message");

        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
       studentRepository.deleteById(id); ;
    }


}
