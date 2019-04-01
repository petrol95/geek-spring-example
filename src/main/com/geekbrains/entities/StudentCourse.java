package com.geekbrains.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students_courses")
public class StudentCourse {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public StudentCourse() {
    }

    @Override
    public String toString() {
        return "StudentCourse id = " + id + ", score = " + score + ", student = " + student.getName()
                + ", course = " + course.getTitle();
    }
}
