package com.schoolbackend.demo.Students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentsJPAResource {

    @Autowired
    private StudentsRepository studentsRepository;


    @GetMapping(path = "/students")
    public List<StudentsEntity> retrieveAllStudents() { return studentsRepository.findAll(); }

    @GetMapping(path = "/students/{id}")
    public EntityModel<StudentsEntity> findOne(@PathVariable int id) throws Exception {
        Optional<StudentsEntity> student =studentsRepository.findById(id);
        if(!student.isPresent()) {
            throw new Exception("id-"+id);
        }
        EntityModel<StudentsEntity> studentsEntityEntityModel = new EntityModel<StudentsEntity>(student.get());
        return studentsEntityEntityModel;
    }

    @PostMapping(path = "/students")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentsEntity student) {
        StudentsEntity savedStudent = studentsRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/students")
    public void deleteStudent(@PathVariable int id) {
        studentsRepository.deleteById(id);
    }

}
