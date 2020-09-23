package com.example.demo.models.mapper;

import com.example.demo.domain.Courses;
import com.example.demo.models.dto.CoursesDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {CoursesMapper.class})
public interface CoursesMapper extends EntityMapper<CoursesDTO, Courses>{


    CoursesDTO toDto(Courses profesores);

    Courses toEntity(CoursesDTO profesoresDTO);

    default Courses fromId(Long id) {
        if (id == null) {
            return null;
        }
        Courses courses = new Courses();
        courses.setId(id);
        return courses;
    }

}
