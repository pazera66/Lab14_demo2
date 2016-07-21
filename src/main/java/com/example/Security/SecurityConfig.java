package com.example.Security;


import com.example.DB.DBSecurityController;
import com.example.Domain.Role;
//import com.example.Domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by karol on 13.07.16.
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)


public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http){
        try {
            http.
                    csrf().
                    disable().
                    requiresChannel().
                    and().
                    authorizeRequests().
                    antMatchers("/resources/**").permitAll().
                    antMatchers("/admin").hasAnyAuthority(String.valueOf(Role.ADMIN)).
                    antMatchers("/superuser").hasAnyAuthority(String.valueOf(Role.SUPERUSER), String.valueOf(Role.ADMIN)).
                    antMatchers("/newUser").hasAnyAuthority(String.valueOf(Role.ADMIN)).
                    anyRequest().authenticated().
                    and().
                    formLogin().
                    permitAll().
                    defaultSuccessUrl("/logged").
                    and().
                    logout().
                    deleteCookies("remember-me").
                    invalidateHttpSession(true).
                    logoutSuccessUrl("/logout").
                    permitAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) {
        try {
            auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    @Autowired
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Autowired
//    UserRepository userRepository(){
//        return new UserRepository(passwordEncoder());
//    }

    @Bean
    @Autowired
    DBSecurityController dbSecurityController(){
        DBSecurityController dbSecurityController = new DBSecurityController(passwordEncoder());
        //dbSecurityController.initailise();
        return dbSecurityController;
    }


    @Autowired
    @Override
    protected UserDetailsService userDetailsService(){
        return dbSecurityController();
    }



}
