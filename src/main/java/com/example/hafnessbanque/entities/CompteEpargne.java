package com.example.hafnessbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteEpargne(String codeCompte, Date dateCreation, double sold, Client client, Employe employe,
			double taux) {
		super(codeCompte, dateCreation, sold, client, employe);
		this.taux = taux;
	}

	
	public CompteEpargne(double taux) {
		super();
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
