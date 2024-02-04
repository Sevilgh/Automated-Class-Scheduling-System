package com.project.scheduling.Controler;


import java.util.List;
import java.util.Optional;

import com.project.scheduling.Model.Course;
import com.project.scheduling.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private  CourseRepository repository;




    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/courses")
    List<Course> all() {
        return (List<Course>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/courses")
    Course newCourse(@RequestBody Course newCourse) {
        return repository.save(newCourse);
    }

    // Single item

    @GetMapping("/courses/{id}")
    Optional<Course> one(@PathVariable int id){
        return repository.findById(id);
    }


    @PutMapping("/course/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable("id") Integer id) {

        return repository.findById(id)
                .map(course -> {
                    course.setNumber(newCourse.getNumber());
                    course.setTitle(newCourse.getTitle());
                    course.setUnit(newCourse.getUnit());
                    course.setMaster1(newCourse.getMaster1());
                    course.setMaster2(newCourse.getMaster2());
                    course.setMaster3(newCourse.getMaster3());
                    return repository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return repository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}