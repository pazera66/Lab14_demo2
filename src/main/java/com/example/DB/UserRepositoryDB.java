package com.example.DB;

import com.example.Domain.Role;
import com.example.Domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karol on 19.07.16.
 */
public class UserRepositoryDB implements UserDetailsService {

    private List<UserDB> users = new ArrayList<UserDB>() {
    };

    PasswordEncoder passwordEncoder;
//    @Autowired
//    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public UserRepositoryDB(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
        users.add(new UserDB("admin", passwordEncoder.encode("admin"), Role.ADMIN));
        users.add(new UserDB("superuser", passwordEncoder.encode("superuser"), Role.SUPERUSER));
        users.add(new UserDB("user", passwordEncoder.encode("user"), Role.USER));
    }

    public void addUser(String login, String password, String role){
        users.add(new UserDB(login, passwordEncoder.encode(password), Role.valueOf(role)));
    }



    public UserDB findByName(String username){
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
