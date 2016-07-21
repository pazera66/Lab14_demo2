package com.example.WebControl;

import com.example.DB.*;
//import com.example.DB.UserRepositoryDB;
import com.example.Domain.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by karol on 20.07.16.
 */
@Controller

public class DBController {



    @Autowired
    private UserDAO userdao;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private DBSecurityController dbSecurityController;

    private String password = "admin";
    private String login = "Admin";
    private String role1 = "ADMIN";
    private String role2 = "USER";





    @RequestMapping(value = "/newuserdb", method = RequestMethod.GET)
    public ModelAndView newUserForm(){
        ModelAndView mav = new ModelAndView("newUserForm2", "userFormModel", new UserFormModel());
        return mav;
    }

    @RequestMapping(value = "/adduserdb", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute UserFormModel userFormModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("newUserForm");
            mav.addObject("userFormModel", userFormModel);
            return mav;
        } else {

            UserDB user = new UserDB(userFormModel.getLogin(), userFormModel.getPassword(), roleDAO.findByRole(userFormModel.getRole()));
            user = dbSecurityController.applySecurity(user);
            userdao.save(user);

            return new ModelAndView("userRegistrationSuccessfull");
        }
    }










    //--------------------------

    @RequestMapping("adduser")
    //@ResponseBody
    public String addUserToDB(){
        String userId = "";
        String roleid = "";
        try  {

            UserDB user = new UserDB(this.login, this.password, roleDAO.findByRole(role1));
            userdao.save(user);
            userId = String.valueOf(user.getUserID());
            roleid = String.valueOf(user.getAssignedRole().getId());
        }
        catch (Exception ex){
            return "Error creating user: " + ex.toString();
        }
        return "User succesfully created with userid = " + userId + " and roleid" + roleid;
    }


    @RequestMapping("getuser")
    @ResponseBody
    public String getByEmail(String login) {
        String userId = "";
        try {
            UserDB user = userdao.findByLogin(login);
            userId = String.valueOf(user.getUserID());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }


    @RequestMapping("addrole")
    public String addRoles(){
        String rolesID = "";
        try {
            RoleDB roleDB1 = new RoleDB(role1);
            RoleDB roleDB2 = new RoleDB(role2);
            roleDAO.save(roleDB1);
            roleDAO.save(roleDB2);
            rolesID = String.valueOf(roleDB1.getId())+ "   " + String.valueOf(roleDB2.getId());
        }
        catch (Exception ex) {
            return "Error while adding roles" + ex.toString();
        }
        return "Roles has been added "  + rolesID;
        //       return "AAAAA";
    }

}


