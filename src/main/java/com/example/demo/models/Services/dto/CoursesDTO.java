package com.example.demo.models.Services.dto;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CoursesDTO  implements Serializable {

   private Long id;
    private String name ;
   // max chart 4
    @Size(max = 4)
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "CoursesDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
