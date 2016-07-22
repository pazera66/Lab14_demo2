package com.example;

import com.example.DB.*;
import com.example.Domain.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static java.lang.invoke.MethodHandles.catchException;
import static org.junit.Assert.*;

/**
 * Created by karol on 21.07.16.
 */
@SpringApplicationConfiguration(classes = Lab14Demo2Application.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class userDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private DBSecurityController dbSecurityController;


    UserDB userdb = new UserDB("test", "test", new RoleDB("USER"));

//    @Before
//    public UserDAO beforeTests() {
//        userDAO.save(userdb);
//        return userDAO;
//    }

    @Test
    public void shouldAddUserToDBTest(){
        UserDB userdb = new UserDB("test", "test", roleDAO.findByRole("USER"));
        userdb = dbSecurityController.applySecurity(userdb);
        userDAO.save(userdb);
        assertEquals(userDAO.findByLogin("test").getLogin(), userdb.getLogin());
    }

    @Test
    public void shouldThrowWhenUserNotFound() {
        UserDB user = userDAO.findByLogin("111111111");
        assertNull(user);

    }



    @Test
    public void shouldThrowWhenUserFound() {
        UserDB user = userDAO.findByLogin("admin");
        assertTrue(user.getAssignedRole().getRole().equals("ADMIN"));
    }
}
