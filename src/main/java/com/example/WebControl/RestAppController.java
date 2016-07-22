package com.example.WebControl;

import com.example.Model.Person;
import org.springframework.web.bind.annotation.*;

/**
 * Created by karol on 19.07.16.
 */
@RestController
public class RestAppController {

    @RequestMapping(value = "/person")
    public Person personAdd() {
        Person person = new Person();
        person.setFirstName("Karol");
        person.setLastName("Krol");
        person.setAge(25);
       return person;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index(@RequestParam String text) {
        return "Default page accessible by annonymous users" + "      Text:\n" + text;
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    String index() {
        return "Your login was successfull";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    String admin() {
//        return "This is ADMIN page accessible only by authenticated and authorized ADMINS";
//    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    String user() {
        return "This is USERS page accessible only by authenticated and authorized USERS";
    }


    @RequestMapping(value = "/superuser", method = RequestMethod.GET)
    String superuser() {
        return "This is SUPERUSER page accessible only by authenticated and authorized SUEPRUSERS";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    String logout() {
        return "Logout successful!";
    }


    @RequestMapping(value = "/test/{username}", method = RequestMethod.GET)
    String testMethod(@PathVariable String username, @RequestParam int age){
        return "This user's name is: " + username + " who is " + age + " years old!";
    }
}
