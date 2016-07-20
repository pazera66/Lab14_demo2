package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * Created by karol on 15.07.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Range(min = 0, max = 99)
    private int age;


//    public String toString(){
//        return "My name is " + firstName + " " + lastName +", and I'm " + age +" years old.";
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
