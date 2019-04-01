package com.geekbrains.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<StudentCourse> studentsInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<StudentCourse> getStudentsInfo() {
        return studentsInfo;
    }

    public void setStudentsInfo(List<StudentCourse> studentsInfo) {
        this.studentsInfo = studentsInfo;
    }

    public Course() {
    }
}
