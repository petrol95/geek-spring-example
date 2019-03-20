package com.geekbrains.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormsController {
    // http://localhost:8189/processForm?studentName=alex

    @RequestMapping("/showSimpleForm")
    public String showSimpleForm() {
        return "myform";
    }

    @RequestMapping(path="/processForm", method=RequestMethod.GET)
    public String processForm() {
        return "myform-result";
    }

}
