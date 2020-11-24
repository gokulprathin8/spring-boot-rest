package com.schoolbackend.demo.Staff;

import com.schoolbackend.demo.Students.StudentsEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class StaffEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 2, message = "staff first name should atleast have two characters")
    private String staff_first_name;

    @NotNull
    @Size(min = 1, message = "staff middle name should be atleast one character")
    private String staff_middle_name;

    @NotNull
    @Size(min = 1, message = "staff last name should atleast be one character")
    private String staff_last_name;

    @OneToMany(mappedBy = "staff")
    private List<StudentsEntity> student;


    public StaffEntity() {
    }

    public StaffEntity(Integer id, @NotNull @Size(min = 2, message = "staff first name should atleast have two characters") String staff_first_name, @NotNull @Size(min = 1, message = "staff middle name should be atleast one character") String staff_middle_name, @NotNull @Size(min = 1, message = "staff last name should atleast be one character") String staff_last_name) {
        this.id = id;
        this.staff_first_name = staff_first_name;
        this.staff_middle_name = staff_middle_name;
        this.staff_last_name = staff_last_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaff_first_name() {
        return staff_first_name;
    }

    public void setStaff_first_name(String staff_first_name) {
        this.staff_first_name = staff_first_name;
    }

    public String getStaff_middle_name() {
        return staff_middle_name;
    }

    public void setStaff_middle_name(String staff_middle_name) {
        this.staff_middle_name = staff_middle_name;
    }

    public String getStaff_last_name() {
        return staff_last_name;
    }

    public void setStaff_last_name(String staff_last_name) {
        this.staff_last_name = staff_last_name;
    }
}
