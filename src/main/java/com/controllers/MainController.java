package com.controllers;

import com.dao.TaskRepo;
import com.modal.Persons;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

   @Autowired
    private PersonService personService;


   @GetMapping("/show")
   public String task(){
       return "index";
   }

   @GetMapping("/getAll")
   public String getAll(HttpServletRequest httpServletRequest){
       httpServletRequest.setAttribute("persons",personService.findAll());
       return "index1";
   }



    @GetMapping("/save")
    public String saveTask() {
        Persons persons = new Persons("Deepanker","Sharma","Mankapur");
        personService.save(persons);
        return "index1";
    }

    @GetMapping("/savePerson")
    public ModelAndView savePerson(@ModelAttribute Persons person) {
        personService.save(person);
//  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("index1");
        List<Persons> personsList = personService.findAll();
        modelAndView.addObject("persons",personsList);
        return modelAndView;
    }


    @GetMapping("/login")
    public ModelAndView login() {
//  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }



    @PostMapping("/getResult")
    public ModelAndView getPerson(@RequestParam Integer id) {
//  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("index1");
        List<Persons> personsList = personService.findAll();
        modelAndView.addObject("persons",personsList);
        return modelAndView;
    }




}
