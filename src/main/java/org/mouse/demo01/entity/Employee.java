package org.mouse.demo01.entity;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    //1.male,  0 female
    private Integer gender;
    private Date birth;
    private Department department;
    private int did;

}
