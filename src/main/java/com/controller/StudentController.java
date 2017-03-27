package com.controller;

import com.dao.*;
import com.model.*;
import com.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
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
    @Autowired
    private StatusRepository statusRepository;

    private final StorageService storageService;

    @Autowired
    public StudentController(StorageService storageService) {
        this.storageService = storageService;
    }

    private Path path;

    @RequestMapping("/Student")
    public String student(Model model){
        List<Student> students = studentRepository.findStudentByDeleteStatusIsTrue(new Sort(Sort.Direction.ASC, "id"));
       model.addAttribute("students", students);
        return "student";
    }
    @RequestMapping("/")
    public String hello(Model model){
        return "hello";
    }
    @RequestMapping(value="/Student", method = RequestMethod.POST)
    public String deleteStudent(Model model, HttpServletRequest request){
        String[] idStudents = request.getParameterMap().get("delete[]");

        for (int i = 0; i < idStudents.length; i++) {
        Student student = studentRepository.findOne(Long.valueOf(idStudents[i]));
        student.setDeleteStatus(Boolean.FALSE);
        studentRepository.save(student);
        }

        return "redirect:Student";
    }
    @GetMapping("/addStudent")
    public String addStudent(Model model){
        Student student = new Student();
        student.getPhones().add(new Phone());
        prepareDateForGet(model, student);
        return "addStudent";
    }
    @RequestMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Student student = studentRepository.findOne(id);
        List<Groupp> groupps = (List<Groupp>) grouppRepository.findAll();
        List<PhoneType> phoneTypes = (List<PhoneType>) phoneTypeRepository.findAll();
        model.addAttribute("groupps", groupps);
        model.addAttribute("phoneTypes", phoneTypes);
        model.addAttribute("student", student);
        return "addStudent";
    }
    @PostMapping(value = "/addStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            prepareDateForGet(model,student);
            return "addStudent";
        }
        LibrarySubscription librarySubscription = new LibrarySubscription();
        MultipartFile image = student.getImageMultipart();
        long millis = System.currentTimeMillis();
        student.setPicturePath(millis + ".jpg");
        storageService.store(student.getImageMultipart(), student.getPicturePath());
        librarySubscription.setStatus("NONE");
        student.setLibrarySubscription(librarySubscription);
        student.setDeleteStatus(true);
        studentRepository.save(student);
        for(Phone phone : student.getPhones()){
            phone.setPerson(student);
            phoneRepository.save(phone);
        }

       return "addStudent";
    }
    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            prepareDateForGet(model,student);
            return "addStudent";
        }
        LibrarySubscription librarySubscription = statusRepository.findOne(student.getLibrarySubscription().getLibsubscriptionId());
        student.setLibrarySubscription(librarySubscription);
        MultipartFile image = student.getImageMultipart();
        student.setPicturePath(student.getId().toString() + ".jpg");
        storageService.store(student.getImageMultipart(), student.getPicturePath());
        student.setDeleteStatus(true);
        studentRepository.save(student);
        for(Phone phone : student.getPhones()){
            phone.setPerson(student);
            phoneRepository.save(phone);
        }
        return "redirect:Student";
    }
    private void prepareDateForGet(Model model, Student student){
        model.addAttribute("groupps", grouppRepository.findAll());
        model.addAttribute("phoneTypes", phoneTypeRepository.findAll());
        model.addAttribute("student", student);
    }
}
