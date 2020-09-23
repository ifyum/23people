package com.example.demo.models.services;



import com.example.demo.domain.Courses;
import com.example.demo.models.dto.CoursesDTO;
import com.example.demo.models.mapper.CoursesMapper;
import com.example.demo.repository.CoursesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //("coursesService")
public class CoursesServiceImpl  implements ICoursesService{
    private final Logger log = LoggerFactory.getLogger(CoursesServiceImpl.class);

    private CoursesRepository coursesRepository;
    private  CoursesMapper coursesMapper;



    public CoursesServiceImpl(CoursesRepository coursesRepository, CoursesMapper coursesMapper) {
        this.coursesRepository = coursesRepository;
        this.coursesMapper = coursesMapper;
    }



//    @Transactional(readOnly = true)
//    public List<CoursesDTO> ListCourses(){
//
//        log.debug("fucking exit for console:"+ coursesRepository.findAll().stream().map(this.coursesMapper::toDto).collect(Collectors.toList()));
//        return coursesRepository.findAll().stream().map(this.coursesMapper::toDto).collect(Collectors.toList());
//    }

    @Override
    public List<Courses> findAll() {
        return coursesRepository.findAll();
    }

    @Override
    public Courses findById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }

    @Override
    public CoursesDTO save(CoursesDTO CoursesDTO) {

        log.debug("Request to save Solicitud : {}", CoursesDTO);

        Courses cliente = coursesMapper.toEntity(CoursesDTO);
        cliente = coursesRepository.save(cliente);

        return coursesMapper.toDto(cliente);
    }

    @Override
    public void delete(Long id) {
        coursesRepository.deleteById(id);
    }



	
}
