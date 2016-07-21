package com.example.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by karol on 21.07.16.
 */
public class DBSecurityController implements UserDetailsService {

    @Autowired
    private UserDAO userdao;

    @Autowired
    private RoleDAO roleDAO;

    private PasswordEncoder passwordEncoder;

    public DBSecurityController(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    public UserDB applySecurity(UserDB user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user = addUserDetails();
        user.setGrantedAuthorities(new SimpleGrantedAuthority(String.valueOf(user.getAssignedRole())));
        return user;
    }

    private UserDB addUserDetails() {

        return null;
    }

    UserDetails createUserDetails(UserDB user){
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash(), true,true,true,true, user.getGrantedAuthorities());
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return createUserDetails(userdao.findByLogin(s));
    }


}
