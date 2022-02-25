package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDetails> findAllUsers(){
        return (List<UserDetails>) userRepository.findAll();
    }

    public UserDetails findById(long id){
        Optional<UserDetails> result = userRepository.findById(id);
        return result.orElse(null);
    }

}
