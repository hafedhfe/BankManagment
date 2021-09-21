package com.example.hafnessbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hafnessbanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
