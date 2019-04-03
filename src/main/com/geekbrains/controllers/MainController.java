package com.geekbrains.controllers;

import com.geekbrains.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // https://getbootstrap.com/docs/4.1/getting-started/introduction/

    @Autowired
    private StudentsRepository studentsRepository;

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }
}
