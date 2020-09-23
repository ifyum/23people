package com.example.demo.models.Services.mapper;

import com.example.demo.models.Services.dto.CoursesDTO;
import com.example.demo.models.entity.Courses;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoursesMapper extends  EntityMapper<CoursesDTO, Courses>{
 CoursesMapper INSTANCE = Mappers.getMapper( CoursesMapper.class );

 CoursesDTO toDto (Courses courses);

    Courses toEntity(CoursesDTO CoursesDTO);


    default Courses fromId (Long id) {
        if (id == null) {
            return null;
        }
        Courses courses = new Courses();
        courses.setId(id);
        return courses;
    }
}
