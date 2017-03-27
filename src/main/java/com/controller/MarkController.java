package com.controller;

import com.dao.DisciplineRepository;
import com.dao.MarkRepository;
import com.dao.ProfesorRepository;
import com.dao.StudentRepository;
import com.model.Discipline;
import com.model.Mark;
import com.model.Profesor;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Student on 2/27/2017.
 */
@Controller
public class MarkController {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MarkRepository markRepository;

    @RequestMapping("/addMark/{id}")
    public String addMark(@PathVariable Long id, Model model) {
        Student student = studentRepository.findOne(id);
        Mark mark = new Mark();
        mark.setStudent(student);
        getParametersForMark(model, mark);
        return "addMark";
    }

    @RequestMapping(value = "/addMark", method = RequestMethod.POST)
    public String saveMark(@ModelAttribute("mark") @Valid Mark mark, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            getParametersForMark(model, mark);
            return "addMark";
        }
        markRepository.save(mark);
        return "redirect:Student";
    }
    private void getParametersForMark(Model model, Mark mark){
        model.addAttribute("mark", mark);
        model.addAttribute("disciplines", disciplineRepository.findAll());
        model.addAttribute("profesors", profesorRepository.findAll());
    }

}

