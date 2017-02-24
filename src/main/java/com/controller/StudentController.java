package com.controller;

import com.dao.*;
import com.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GrouppRepository grouppRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneTypeRepository phoneTypeRepository;
    private Path path;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("name");
        return "hello";
    }
    @RequestMapping("/Student")
    public String student(Model model){
        List<Student> students = (List<Student>) studentRepository.findAll();
        model.addAttribute("students", students);
        return "student";
    }
    @RequestMapping("/addStudent")
    public String addStudent(Model model){
        List<Groupp> groupps = (List<Groupp>) grouppRepository.findAll();
        List<Discipline> disciplines = (List<Discipline>) disciplineRepository.findAll();
        List<PhoneType> phoneTypes = (List<PhoneType>) phoneTypeRepository.findAll();
        Student student = new Student();
        student.getPhones().add(new Phone());
        model.addAttribute("groupps", groupps);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("phoneTypes", phoneTypes);
        model.addAttribute("student", student);
        return "addStudent";
    }
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String saveStudent(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("student") Student student, Model model){
      Student student1 = student;
      LibrarySubscription librarySubscription = new LibrarySubscription();
      librarySubscription.setStatus("NONE");
      student.setLibrarySubscription(librarySubscription);
       studentRepository.save(student);
        MultipartFile image = student.getImageMultipart();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get("C:/Users/Student/IdeaProjects/student/src/main/resources/static/image/"+ student.getId() +".jpg");
        if (image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }
        for(Phone phone : student.getPhones()){
            phone.setPerson(student);
            phoneRepository.save(phone);
        }
       return "addStudent";
    }
}
