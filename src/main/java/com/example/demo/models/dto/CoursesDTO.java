package com.example.demo.models.dto;

public class CoursesDTO {

    private String name ;


    // max chart 4
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
