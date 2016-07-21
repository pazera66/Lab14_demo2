//package com.example;
//
//import com.example.DB.RoleDB;
//import com.example.DB.UserDAO;
//import com.example.DB.UserDB;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//
//import static java.lang.invoke.MethodHandles.catchException;
//import static org.junit.Assert.assertThat;
//
///**
// * Created by karol on 21.07.16.
// */
//public class ShouldAddNewUser {
//
//    @Autowired
//    private UserDAO userDAO;
//
//
//    UserDB userdb = new UserDB("test", "test", new RoleDB("USER"));
//
//
//
//    @Test
//    public void shouldThrowWhenUserNotFound() {
//        catchException(userDAO, EmptyResultDataAccessException.class).findByNumber("111111111");
//
//        assertThat(caughtException()).isNotNull();
//    }
//}
