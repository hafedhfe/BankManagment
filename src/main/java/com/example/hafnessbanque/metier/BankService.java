package com.example.hafnessbanque.metier;

import org.springframework.data.domain.Page;

import com.example.hafnessbanque.entities.*;

public interface BankService {
	
	public Compte consulterCompte(String codeCompte);
	public Employe consulterEmploye(Long codeEmploye);
	public void verser(Long codeEmploye,String codeCompte, double montant);
	public void retirer(Long codeEmploye,String codeCompte, double montant);
	public void virement(Long codeEmploye,String codeCompte1,String codeCompte2,double montant);
	public Page<Operation> listOperationsCompte(String codeCompte,int page, int size);
	public Page<Operation> listOperationsByEmployee(Long codeEmploye,int page, int size);
	

}
