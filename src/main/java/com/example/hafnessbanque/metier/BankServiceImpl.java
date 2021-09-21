package com.example.hafnessbanque.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hafnessbanque.dao.*;
import com.example.hafnessbanque.entities.*;
@Service
@Transactional
public class BankServiceImpl implements BankService {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCompte) {
		Optional<Compte> cpt= compteRepository.findById(codeCompte);
		if(cpt.get()==null) 
			throw new RuntimeException("Compte introuvable!");
		return cpt.get();
	}

	@Override
	public Employe consulterEmploye(Long codeEmploye) {
		Optional<Employe> emp= employeRepository.findById(codeEmploye);
		if(emp.get()==null) 
			throw new RuntimeException("Employee introuvable!");
		return emp.get();
	}

	@Override
	public void verser(Long codeEmploye, String codeCompte, double montant) {
		Compte cpt = consulterCompte(codeCompte);
		Employe emp = consulterEmploye(codeEmploye);
		Versement v = new Versement(new Date(),montant,cpt,emp);
		operationRepository.save(v);
		cpt.setSolde(cpt.getSolde()+montant);
		compteRepository.save(cpt);

	}
	@Override
	public void retirer(Long codeEmploye, String codeCompte, double montant) {
		Compte cpt = consulterCompte(codeCompte);
		double facilitesCaisse = 0 ;
		if(cpt instanceof CompteCourant)
			facilitesCaisse=((CompteCourant) cpt).getDecouvert();
		if(cpt.getSolde()+facilitesCaisse < montant)
			throw new RuntimeException("Solde insuffisant!");
		Employe emp = consulterEmploye(codeEmploye);
		Retrait r = new Retrait(new Date(),montant,cpt,emp);
		operationRepository.save(r);
		cpt.setSolde(cpt.getSolde()-montant);
		compteRepository.save(cpt);
		
	}
	@Override
	public void virement(Long codeEmploye, String codeCompte1, String codeCompte2, double montant) {
		if(codeCompte1.equals(codeCompte2))
			throw new RuntimeException("Impossible virement sur le même compte");
		retirer(codeEmploye,codeCompte1,montant);
		verser(codeEmploye, codeCompte2, montant);
	}
	@Override
	public Page<Operation> listOperationsCompte(String codeCompte, int page, int size) {
		return operationRepository.listOperation(codeCompte, PageRequest.of(page, size));
	}
	@Override
	public Page<Operation> listOperationsByEmployee(Long codeEmploye, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}


}
