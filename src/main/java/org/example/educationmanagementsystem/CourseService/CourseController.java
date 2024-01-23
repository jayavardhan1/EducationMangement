package org.example.educationmanagementsystem.CourseService;

import org.example.educationmanagementsystem.CourseService.DTO.CreateCourseDTO;
import org.example.educationmanagementsystem.CourseService.models.CourseModel;
import org.example.educationmanagementsystem.CourseService.models.Department;
import org.example.educationmanagementsystem.Exceptions.EnterNonNullFields;
import org.example.educationmanagementsystem.Exceptions.classNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "course")
public class CourseController {
    @Autowired
    private final CourseService courseService;
    @Autowired
    private final CourseRepo courseRepo;

    public CourseController(CourseService courseService , CourseRepo courseRepo) {
        this.courseService = courseService;
        this.courseRepo = courseRepo;
    }

    //create course
    @PostMapping(path = "/create")
    ResponseEntity<CourseModel> createCourse(@RequestBody CreateCourseDTO createCourseDTO) {
        createCourseDTO.ValidateNonNullFields();
        CourseModel output = courseService.createCourse(
                createCourseDTO.getTitle(),
                createCourseDTO.getDescription(),
                createCourseDTO.getStartDate(),
                createCourseDTO.getEndDate(),
                createCourseDTO.getTeacherId(),
                createCourseDTO.getCapacity(),
                createCourseDTO.getCourseCode(),
                createCourseDTO.getDepartment()
        );

        return ResponseEntity.ok(output);
    }

    // get course by id
    @GetMapping(path = "/{id}")
    ResponseEntity<CourseModel> getCourseById(@PathVariable("id") Long id) {
        CourseModel course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    // get all courses
    @GetMapping(path = "/all")
    ResponseEntity<List<CourseModel>> getAllCourses() {
        List<CourseModel> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);
    }
    // get by department
    @GetMapping(path = "/department/{department}")
    ResponseEntity<List<CourseModel>> getCoursesByDepartment(@PathVariable("department") Department department) {
        // check if department exists in Enum Department
        if (!courseRepo.existsByDepartment(department)) {
            throw new classNotFoundException(0L);
        }

        List<CourseModel> courses = courseService.getCoursesByDepartment(department);
        return ResponseEntity.ok(courses);
    }

    // update course
    @PutMapping(path = "/{id}")
    ResponseEntity<String> updateCourse(@PathVariable("id") Long id, @RequestBody CreateCourseDTO courseDTO) {
        courseDTO.ValidateNonNullFields();
        String output = courseService.updateCourse(id,
                courseDTO.getTitle(),
                courseDTO.getDescription(),
                courseDTO.getStartDate(),
                courseDTO.getEndDate(),
                courseDTO.getTeacherId(),
                courseDTO.getCapacity(),
                courseDTO.getCourseCode());
        return ResponseEntity.ok(output);
    }

    // delete course
    @DeleteMapping(path = "/{id}")
    ResponseEntity<String> deleteCourse(@PathVariable("id") Long id) {

        String output = courseService.deleteCourse(id);
        return ResponseEntity.ok(output);
    }
}
