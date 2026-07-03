package com.project.eventy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.eventy.entity.User;
import com.project.eventy.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myuser = userRepository.getByUsername(username);

        if(myuser == null){
            throw new UsernameNotFoundException("User not found with the given username");
        }
 

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(myuser.getRole().name());
     

        List<GrantedAuthority> authorities = List.of(authority);

        org.springframework.security.core.userdetails.User userr = new org.springframework.security.core.userdetails.User(myuser.getUsername(), myuser.getPassword(), authorities);

        return userr;

    }

    

   

}
