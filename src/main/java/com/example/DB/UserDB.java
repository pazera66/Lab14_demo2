package com.example.DB;

import com.example.Domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karol on 19.07.16.
 */
public class UserDB {

    private String login;
    private String passwordHash;
    private Role role;

    List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();

    public UserDB (){}

    UserDB(String login, String passwordHash, Role role){
        this.login=login;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    UserDetails createUserDetails(){
        grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
        return new org.springframework.security.core.userdetails.User(login, passwordHash, true,true,true,true, grantedAuthorities);
    }


    String getLogin(){
        return login;
    }




}
