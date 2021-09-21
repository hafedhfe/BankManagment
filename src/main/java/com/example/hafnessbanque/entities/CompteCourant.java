package com.example.hafnessbanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	private double decouvert;

	public CompteCourant() {
		super();
	}
	
	public CompteCourant(String codeCompte, Date dateCreation, double sold, Client client, Employe employe,
			double decouvert) {
		super(codeCompte, dateCreation, sold, client, employe);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
