package com.example.FirstProject.serviceImpl;

import com.example.FirstProject.model.Users;
import com.example.FirstProject.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users =  userDetailsRepository.findByUserName(username)
                .orElseThrow(() ->  new UsernameNotFoundException("UserName not found"));
        return users;
    }

    public Users registerUser(String username, String rawPassword) {
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(rawPassword)); // 🔒 Secure hash
        user.setRole("USER");


        Users a = userDetailsRepository.save(user);
        return a;
    }
}
