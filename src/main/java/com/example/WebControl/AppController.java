package com.example.WebControl;

import com.example.Domain.User;
import com.example.Domain.UserFormModel;
import com.example.Domain.UserRepository;
import com.example.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by karol on 13.07.16.
 */

@Controller
public class AppController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/newPerson", method = RequestMethod.GET)
    public ModelAndView newPersonForm() {
    ModelAndView mav = new ModelAndView("newPerson", "person", new Person());
    return mav;
    }



    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("newPerson");
            mav.addObject("person", person);
            return mav;
        } else {
            modelMap.addAttribute("firstName", person.getFirstName());
            modelMap.addAttribute("lastName", person.getLastName());
            modelMap.addAttribute("age", person.getAge());
            return new ModelAndView("result").addObject(modelMap);
        }
    }


    //------------------------------------------------

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public ModelAndView newUserForm(){
        ModelAndView mav = new ModelAndView("newUserForm", "userFormModel", new UserFormModel());
        return mav;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute UserFormModel userFormModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("newUserForm");
            mav.addObject("userFormModel", userFormModel);
            return mav;
        } else {

            userRepository.addUser(userFormModel.getLogin(), userFormModel.getPassword(), userFormModel.getRole());

            return new ModelAndView("userRegistrationSuccessfull");
        }
    }



}
