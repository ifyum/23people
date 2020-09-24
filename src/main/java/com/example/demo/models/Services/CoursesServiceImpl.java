package com.example.demo.models.Services;


import com.example.demo.models.Services.mapper.CoursesMapper;
import org.springframework.stereotype.Service;

import com.example.demo.models.Services.dto.CoursesDTO;

import com.example.demo.models.entity.Courses;
import com.example.demo.models.repository.CoursesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CoursesServiceImpl implements ICoursesService {

    private final Logger log = LoggerFactory.getLogger(CoursesServiceImpl.class);

    @Autowired
    private CoursesRepository coursesRepository;
//    @Autowired
//    private  CoursesMapper coursesMapper;
//

    @Override
    @Transactional(readOnly = true)
    public List<Courses> findAll() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses findById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }


    @Override
    public Courses save(Courses courses) {

        log.debug("Request to save courses : {}", courses);

        return coursesRepository.save(courses);
    }

//    @Override
//    public CoursesDTO save(CoursesDTO coursesDTO) {
//        log.debug("Request to save courses : {}", coursesDTO);
//
//        Courses courses = coursesMapper.toEntity(coursesDTO);
//        courses = coursesRepository.save(courses);
//
//        return coursesMapper.toDto(courses);
//    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        coursesRepository.deleteById(id);
    }





}
