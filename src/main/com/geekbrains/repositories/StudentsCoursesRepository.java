package com.geekbrains.repositories;

import com.geekbrains.entities.StudentCourse;
import org.springframework.data.repository.CrudRepository;

public interface StudentsCoursesRepository extends CrudRepository<StudentCourse, Long> {
}
