package com.example.DB;

import com.example.Domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karol on 19.07.16.
 */
@Entity
@Table(name="users")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String login;

    @NotNull
    private String passwordHash;

    @NotNull
    private Role role;

    //List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();

    public UserDB (){}

    public UserDB(long id){
        this.id=id;
    }

    public UserDB(String login, String passwordHash, String role){
        this.login=login;
        this.passwordHash = passwordHash;
        this.role = Role.valueOf(role);
    }



//    UserDetails createUserDetails(){
//        grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
//        return new org.springframework.security.core.userdetails.User(login, passwordHash, true,true,true,true, grantedAuthorities);
//    }


    String getLogin(){
        return login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
