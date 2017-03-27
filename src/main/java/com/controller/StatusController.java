package com.controller;

import com.dao.StatusRepository;
import com.dao.StudentRepository;
import com.model.LibrarySubscription;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Student on 2/24/2017.
 */
@Controller

public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/editStatus", method = RequestMethod.POST)
    public String addStatus(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("librarySubscription") LibrarySubscription librarySubscription, Model model){
        statusRepository.save(librarySubscription);
        return "redirect:Student";
    }


    @RequestMapping("/editStatus/{id}")
    public String editStatus(@PathVariable Long id, Model model){

        LibrarySubscription librarySubscription = statusRepository.findOne(id);
        Student student = studentRepository.findStudentByLibrarySubscription(librarySubscription);
        model.addAttribute("librarySubscription", librarySubscription);
        model.addAttribute("student", student);
        return "editStatus";
    }

}
