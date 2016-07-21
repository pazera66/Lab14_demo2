package com.example.DB;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karol on 19.07.16.
 */
@Entity
public class RoleDB {


    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String role;

    @OneToMany
    private List<UserDB> usersSet = new ArrayList<UserDB>();

    public RoleDB(String role){
        this.role = role;
    }

    RoleDB(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
