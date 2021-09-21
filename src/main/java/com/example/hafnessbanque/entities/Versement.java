package com.example.hafnessbanque.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date dateOperation, double montant, Compte compte, Employe employe) {
		super(dateOperation, montant, compte, employe);
		// TODO Auto-generated constructor stub
	}	
}
