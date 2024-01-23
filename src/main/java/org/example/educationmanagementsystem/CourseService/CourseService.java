package org.example.educationmanagementsystem.CourseService;

import org.example.educationmanagementsystem.CourseService.models.CourseModel;
import org.example.educationmanagementsystem.CourseService.models.Department;
import org.example.educationmanagementsystem.Exceptions.classNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    List<CourseModel> getCourses() {
        return courseRepo.findAll();
    }

    CourseModel getCourseById(Long id) {
        return courseRepo.findById(id).orElseThrow(() ->
                new classNotFoundException(id));
    }


    String updateCourse(Long id, String title, String description, Date startDate, Date endDate, Long teacherId, int capacity,String courseCode) {

        CourseModel course = courseRepo.findById(id).orElseThrow(() ->
                new classNotFoundException(id));
        course.setTitle(title);
        course.setDescription(description);
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        course.setTeacherId(teacherId);
        course.setCapacity(capacity);
        course.setCourseCode(courseCode);
        courseRepo.save(course);

        return "Course updated";
    }

    String deleteCourse(Long id) {
        // check if course exists
        boolean exists = courseRepo.existsById(id);
        if (!exists) {
            throw new classNotFoundException(id);
        }
        courseRepo.deleteById(id);
        return "Course deleted";
    }

    public CourseModel createCourse(String title, String description, Date startDate, Date endDate, Long teacherId, int capacity, String courseCode, Department department) {
        CourseModel newCourse = new CourseModel();
        newCourse.setTitle(title);
        newCourse.setDescription(description);
        newCourse.setStartDate(startDate);
        newCourse.setEndDate(endDate);
        newCourse.setCapacity(capacity);
        newCourse.setTeacherId(teacherId);
        newCourse.setCourseCode(courseCode);
        newCourse.setDepartment(department);
        return courseRepo.save(newCourse);
    }

    public List<CourseModel> getCoursesByDepartment(Department department) {
        return courseRepo.findByDepartment(department);
    }
}
