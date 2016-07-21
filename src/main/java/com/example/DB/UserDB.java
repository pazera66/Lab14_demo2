package com.example.DB;

import com.example.Domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sun.java2d.pipe.SpanShapeRenderer;

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
    private long userID;

    @NotNull
    private String login;

    @NotNull
    private String passwordHash;


    @ManyToOne
    private RoleDB assignedRole;

    private List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();


    public UserDB (){}


    public UserDB(String login, String passwordHash, RoleDB role){
        this.login=login;
        this.passwordHash = passwordHash;
        this.assignedRole = role;
    }



    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
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

    public RoleDB getAssignedRole() {
        return assignedRole;
    }

    public void setAssignedRole(RoleDB assignedRole) {
        this.assignedRole = assignedRole;
    }

    public List<SimpleGrantedAuthority> getGrantedAuthorities() {

        return grantedAuthorities;
    }

    public void setGrantedAuthorities(SimpleGrantedAuthority authority) {
        grantedAuthorities.add(authority);
    }
}
