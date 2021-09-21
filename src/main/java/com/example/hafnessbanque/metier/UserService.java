package com.example.hafnessbanque.metier;

import org.springframework.stereotype.Service;

import com.example.hafnessbanque.entities.UserAuth;
@Service
public interface UserService {
  
 public UserAuth findUserByEmail(String email);
 
 public void saveUser(UserAuth userAuth);
}
