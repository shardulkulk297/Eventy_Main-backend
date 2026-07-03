package com.project.eventy.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.eventy.entity.User;
import com.project.eventy.entity.enums.Role;
import com.project.eventy.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User signUp(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

    public Object getLoggedInUserDetails(String username) {
        
        User userToFind = userRepository.getByUsername(username);

        switch(userToFind.getRole()){
            case Role.EVENT_MANAGER->{


            }
            case Role.PARTICIPANT->{

            }
            case Role.SUPER_ADMIN->{
                
            }
            case Role.ORG_ADMIN->{

                return null;

            }

            default -> {
                return null;
            }

        }

        return null;
            
    }

    
}