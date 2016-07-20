package com.example.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by karol on 13.07.16.
 */
public class UserRepository implements UserDetailsService{

    private List<User> users = new ArrayList<User>() {
    };

    PasswordEncoder passwordEncoder;
//    @Autowired
//    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public UserRepository(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        users.add(new User("admin", passwordEncoder.encode("admin"), Role.ADMIN));
        users.add(new User("superuser", passwordEncoder.encode("superuser"), Role.SUPERUSER));
        users.add(new User("user", passwordEncoder.encode("user"), Role.USER));
    }

    public void addUser(String login, String password, String role){
        users.add(new User(login, passwordEncoder.encode(password), Role.valueOf(role)));
    }



    public User findByName(String username){
        for(int i = 0; i<users.size(); i++){
            if(users.get(i).getLogin().toString().equals(username)){
                return users.get(i);
            }
        }

        throw new UsernameNotFoundException("User with username: " + username + " has not been found!");

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return findByName(username).createUserDetails();
    }

}
