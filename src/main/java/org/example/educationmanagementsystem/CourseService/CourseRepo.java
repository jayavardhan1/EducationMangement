package org.example.educationmanagementsystem.CourseService;
import org.example.educationmanagementsystem.CourseService.models.CourseModel;
import org.example.educationmanagementsystem.CourseService.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface  CourseRepo extends JpaRepository<CourseModel, Long> {

    List<CourseModel> findByDepartment(Department department);

    boolean existsByDepartment(Department department);
}

// make sample course data
