package org.example.educationmanagementsystem.CourseService.DTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.educationmanagementsystem.Exceptions.EnterNonNullFields;
import java.util.Date;
import org.example.educationmanagementsystem.CourseService.models.Department;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDTO {
    @NonNull
    private String title;
    private String description;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    private Long teacherId;
    private int capacity;
    @NonNull
    private String courseCode;
    private Department department;

    // validating non fileds
    public void ValidateNonNullFields() {
        if (title == null || title.isEmpty()) {
            throw new EnterNonNullFields("Title is required");
        }
        if (startDate == null) {
            throw new EnterNonNullFields("Start date is required");
        }
        if (endDate == null) {
            throw new EnterNonNullFields("End date is required");
        }
        if (courseCode == null || courseCode.isEmpty()) {
            throw new EnterNonNullFields("Course code is required");
        }
    }

    @Override
    public String toString() {
        return "CreateCourseDTO{" + "title=" + title + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", teacherId=" + teacherId + ", capacity=" + capacity + " Course code "+courseCode+ "}" ;
    }
}
