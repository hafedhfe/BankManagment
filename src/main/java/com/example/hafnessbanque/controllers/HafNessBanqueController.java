package com.example.hafnessbanque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hafnessbanque.entities.Compte;
import com.example.hafnessbanque.entities.Operation;
import com.example.hafnessbanque.metier.BankService;

@Controller
public class HafNessBanqueController {
	@Autowired
	private BankService bankService;

	@GetMapping("/operations")
	public String index() {
		return "comptes";
	}

	@GetMapping("/comptes")
	public String consulterCompte(Model model, String codeCompte) {
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cpt = bankService.consulterCompte(codeCompte);
			Page<Operation> page = bankService.listOperationsCompte(codeCompte, 0, 4);
			model.addAttribute("listOperation", page.getContent());
			model.addAttribute("compte", cpt);
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "comptes";
	}
	
	@PostMapping("/saveOperation")
	public String saveOperation(Model model, Long codeEmploye,String codeCompte, String typeOperation, String codeCompte2 , double montant ) {
		try {
			if(typeOperation.equals("VERS"))
				bankService.verser(codeEmploye, codeCompte, montant);
			if(typeOperation.equals("RETR"))
				bankService.retirer(codeEmploye, codeCompte, montant);
			if(typeOperation.equals("VIR"))
				bankService.virement(codeEmploye, codeCompte, codeCompte2, montant);
		}catch (Exception e) {
			return "redirect:/comptes?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
	return "redirect:/comptes?codeCompte="+codeCompte;
	}
}
