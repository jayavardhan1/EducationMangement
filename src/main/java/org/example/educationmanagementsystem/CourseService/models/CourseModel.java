package org.example.educationmanagementsystem.CourseService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String courseCode;
    @NonNull
    private String title;
    private String description;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    private int capacity;
    private Long teacherId;
    private Department department;

    public CourseModel(String english, String english1, Date date, Date date1, int i, long l, String eng101, Department department) {
    }

    @Override
    public String toString() {
        return "CourseModel{" + "title=" + title + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", teacherId=" + teacherId ;
    }

}

