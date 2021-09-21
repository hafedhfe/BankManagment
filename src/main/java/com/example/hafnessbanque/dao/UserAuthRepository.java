package com.example.hafnessbanque.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hafnessbanque.entities.UserAuth;
 

@Repository("userRepository")
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
// @Query( "select email, password from user where email=:u")

	public UserAuth findByEmail(String email);
}
