package com.example.WebControl;

import com.example.DB.UserDAO;
import com.example.DB.UserDB;
//import com.example.DB.UserRepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by karol on 20.07.16.
 */
@Controller

public class DBController {

    @Autowired
    private UserDAO userdao;

    private String role = "ADMIN";
    private String password = "admin";

    @RequestMapping("/add")
    @ResponseBody
    public String addUserToDB(String login){
        String userId = "";
        try  {
            UserDB user = new UserDB(login, this.password, this.role);
            userdao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex){
            return "Error creating user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }


    @RequestMapping("/get")
    @ResponseBody
    public String getByEmail(String login) {
        String userId = "";
        try {
            UserDB user = userdao.findByLogin(login);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }
}


