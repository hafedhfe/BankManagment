package com.example.hafnessbanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hafnessbanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
