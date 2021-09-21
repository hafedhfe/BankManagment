package com.example.hafnessbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hafnessbanque.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
