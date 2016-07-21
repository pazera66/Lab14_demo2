package com.example.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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
//        roleDAO.save(new RoleDB("ADMIN"));
//        roleDAO.save(new RoleDB("USER"));
//        roleDAO.save(new RoleDB("SUPERUSER"));
//        userdao.save(new UserDB("admin", passwordEncoder.encode("admin"), roleDAO.findByRole("ADMIN")));
    }

    public UserDB applySecurity(UserDB user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return user;
    }

    UserDetails createUserDetails(UserDB user){
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getAssignedRole().getRole()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPasswordHash(), true,true,true,true, grantedAuthorities);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return createUserDetails(userdao.findByLogin(s));
    }

    @PostConstruct
    public void initailise() {
        roleDAO.save(new RoleDB("ADMIN"));
        roleDAO.save(new RoleDB("USER"));
        roleDAO.save(new RoleDB("SUPERUSER"));
        userdao.save(new UserDB("admin", passwordEncoder.encode("admin"), roleDAO.findByRole("ADMIN")));
    }
}
