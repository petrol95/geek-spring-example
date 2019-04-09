package com.geekbrains.controllers;

import com.geekbrains.entities.Student;
import com.geekbrains.entities.StudentCourse;
import com.geekbrains.repositories.StudentsCoursesRepository;
import com.geekbrains.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/students")
@Transactional
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/list")
    @Transactional
    public String showStudentsList(Model model) {
        List<Student> allStudents = studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents);
        return "students-list";
    }


    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Student student = new Student();
        student.setName("Unknown");
        model.addAttribute("student", student);
        return "add-student-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Student student) {
        studentsService.addStudent(student);
        return "redirect:/students/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long studentId) {
        studentsService.removeById(studentId);
        return "redirect:/students/list";
    }

    @RequestMapping(path="/courses/{id}", method=RequestMethod.GET)
    public String showStudentsCoursesInfo(Model model, @PathVariable(value = "id") Long studentId) {
        model.addAttribute("studentCourses", studentsService.getCoursesByStudentId(studentId));
        model.addAttribute("studentMissingCourses", studentsService.getMissingCoursesByStudentId(studentId));
        return "student-courses-list";
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
//        @RequestMapping(path="/add", method=RequestMethod.POST)
//    public String showAddForm(@RequestParam(value="student") Student student) {
//        studentsService.addStudent(student);
//        return "redirect:/students/list";
//    }

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
