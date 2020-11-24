package com.schoolbackend.demo.Students;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.schoolbackend.demo.Staff.StaffEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class StudentsEntity {

    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min = 2, message = "Student first name should be more than 2 characters")
    private String first_name;

    @Size(min = 1, message = "Student middle name should be atleast one character")
    private String middle_name;

    @Size(min = 1, message = "Student last name should be atleast one character")
    private String last_name;

    @Past
    @NotNull
    private Date birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private StaffEntity staff;


    public StudentsEntity() {
    }

    public StudentsEntity(Integer id, @NotNull @Size(min = 2, message = "Student first name should be more than 2 characters") String first_name, @NotNull @Size(min = 1, message = "Student middle name should be atleast one character") String middle_name, @NotNull @Size(min = 1, message = "Student last name should be atleast one character") String last_name, @Past @NotNull Date birthday) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
