package com.geekbrains.controllers;

import com.geekbrains.entities.Student;
import com.geekbrains.entities.StudentCourse;
import com.geekbrains.repositories.StudentsCoursesRepository;
import com.geekbrains.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsCoursesRepository studentsCoursesRepository;

    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/list")
    public String showStudentsList(Model model) {
        List<Student> allStudents = studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents);
        List<StudentCourse> list = (List)studentsCoursesRepository.findAll();
        System.out.println(list);
//        System.out.println(allStudents.get(0).getCourses());
        return "students-list";
    }
//    private StudentsService studentsService;
//
//    @Autowired
//    public void setStudentsService(StudentsService studentsService) {
//        this.studentsService = studentsService;
//    }
//
//    public StudentsController() {
//    }
//
//    // localhost:8189/students/showForm
//    @RequestMapping("/showForm")
//    public String showSimpleForm(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "student-form";
//    }
//
//    @RequestMapping("/processForm")
//    public String processForm(@ModelAttribute("student") Student student) {
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//        return "student-form-result";
//    }
//
//    // http://localhost:8189/students/showStudentById?id=5
//    @RequestMapping(path="/showStudentById", method=RequestMethod.GET)
//    public String showStudentById(Model model, @RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        model.addAttribute("student", student);
//        return "student-form-result";
//    }
//
//    // http://localhost:8189/students/getStudentById?id=10
//    @RequestMapping(path="/getStudentById", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentById(@RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
//
//    // http://localhost:8189/students/getStudentById/15
//    @RequestMapping(path="/getStudentById/{sid}", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentByIdFromPath(@PathVariable("sid") int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
}
