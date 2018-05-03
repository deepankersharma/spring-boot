package com.controllers;

import com.dao.TaskRepo;
import com.modal.Persons;
import com.modal.SecUser;
import com.modal.User;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import static com.modal.RoleConstraint.AdminRole;
import static com.modal.RoleConstraint.SuerAdminRole;

@Controller
@PreAuthorize("hasAnyRole('USER_ROLE','ADMIN')")
public class MainController {

   @Autowired
    private PersonService personService;


   @GetMapping("/show")
   @PreAuthorize("hasAnyRole('USER_ROLE','ADMIN')")
   public String task(Model model){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       model.addAttribute("person",new Persons());
       return "index";
   }

   @GetMapping("/getAll")
//   @Secured({"USER_ROLE","ADMIN"})
   @PreAuthorize("hasAnyRole('USER_ROLE','ADMIN')")
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

    @PostMapping(value = "/savePerson")
    public ModelAndView savePerson(@ModelAttribute Persons person) {
        personService.save(person);
        //  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("index1");
        List<Persons> personsList = personService.findAll();
        modelAndView.addObject("persons",personsList);
        return modelAndView;
    }


    @GetMapping("/index")
    @PreAuthorize("permitAll()")
    public ModelAndView login() {
//  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }



    @GetMapping("/getResult")
    public ModelAndView getPerson() {
//  redirect:/user/home      ModelAndView modelAndView = new ModelAndView("index1");
        ModelAndView modelAndView = new ModelAndView("index1");
        List<Persons> personsList = personService.findAll();
        modelAndView.addObject("persons",personsList);
        return modelAndView;
    }

    @GetMapping("/accessDenied")
    public ModelAndView getAccessDeniedPage(){
       ModelAndView modelAndView = new ModelAndView("accessDenied");
       return modelAndView;
    }





}
