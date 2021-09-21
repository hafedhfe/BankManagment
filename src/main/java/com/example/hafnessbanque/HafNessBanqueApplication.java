package com.example.hafnessbanque;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.hafnessbanque.dao.*;
import com.example.hafnessbanque.entities.*;
import com.example.hafnessbanque.metier.BankService;

@SpringBootApplication
@ComponentScan({"com.example.hafnessbanque","com.example.hafnessbanque.controllers"})
@EnableAutoConfiguration()

public class HafNessBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository; 
	@Autowired
	private BankService banqueService;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(HafNessBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("hafedh"));
		Client c2 = clientRepository.save(new Client("nessrine"));
		
		Employe emp1 = employeRepository.save(new Employe("ezzidinne"));
		Employe emp2 = employeRepository.save(new Employe("mustpha"));
		
		Compte cpt1 = compteRepository.save(new CompteCourant("c1",new Date(),10000,c1,emp1,5000));
		Compte cpt2 = compteRepository.save(new CompteEpargne("c2",new Date(),7000,c2,emp2,9.5));
		
		banqueService.verser(emp1.getCodeEmploye(), cpt1.getCodeCompte(), 1200);
		banqueService.retirer(emp1.getCodeEmploye(), cpt1.getCodeCompte(), 8000);
		Compte cpt = banqueService.consulterCompte("c1");
		
	}

}
