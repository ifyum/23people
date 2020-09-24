package com.example.demo.models.Services.mapper;

import com.example.demo.models.Services.dto.StudentDTO;
import com.example.demo.models.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper extends  EntityMapper<StudentDTO, Student>{
    StudentMapper INSTANCE = Mappers.getMapper( StudentMapper.class );

    StudentDTO toDto (Student student);

    Student toEntity(StudentDTO studentDTO);


    default Student fromId (Long id) {
        if (id == null) {
            return null;
        }
        Student student = new Student();
        student.setId(id);
        return student;
    }
}
