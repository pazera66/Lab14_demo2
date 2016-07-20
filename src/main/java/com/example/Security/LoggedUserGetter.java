//package com.example.Security;
//
//import com.example.Domain.User;
//import com.example.Domain.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoggedUserGetter  {
//    @Autowired
//    public LoggedUserGetter(UserRepository userRepository, BackendAuthenticator backendAuthenticator) {
//        this.userRepository = userRepository;
//        this.backendAuthenticator = backendAuthenticator;
//    }
//
//    public UserDetails getLoggedUserDetails() {
//        UserDetails loggedUserDetails = null;
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (backendAuthenticator.isAuthenticated(authentication)) {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserDetails) {
//                loggedUserDetails = ((UserDetails) principal);
//            } else {
//                throw new RuntimeException("Expected class of authentication principal is AuthenticationUserDetails. Given: " + principal.getClass());
//            }
//
//        }
//
//        return loggedUserDetails;
//    }
//
//    public String getLoggedUserName() {
//        return getLoggedUserDetails().getUsername();
//    }
//
//    public User getLoggedUser() {
//        return userRepository.findByName(getLoggedUserName());
//    }
//
//    private UserRepository userRepository;
//    private BackendAuthenticator backendAuthenticator;
//}
