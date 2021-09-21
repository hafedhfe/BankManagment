package com.example.hafnessbanque.metier;


import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hafnessbanque.dao.RoleRespository;
import com.example.hafnessbanque.dao.UserAuthRepository;
import com.example.hafnessbanque.entities.Role;
import com.example.hafnessbanque.entities.UserAuth;

@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserAuthRepository userAuthRepository;
 
 @Autowired
 private RoleRespository roleRespository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public UserAuth findUserByEmail(String email) {
  return userAuthRepository.findByEmail(email);
 }

 @Override
 public void saveUser(UserAuth userAuth) {
  userAuth.setPassword(bCryptPasswordEncoder.encode(userAuth.getPassword()));
  userAuth.setActive(1);
  Role userRole = roleRespository.findByRole("ADMIN");
  userAuth.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
  userAuthRepository.save(userAuth);
 }

}