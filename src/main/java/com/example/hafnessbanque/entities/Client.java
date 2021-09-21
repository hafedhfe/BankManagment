package com.example.hafnessbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> compte;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Collection<Compte> getCompte() {
		return compte;
	}
	public void setCompte(Collection<Compte> compte) {
		this.compte = compte;
	} 

}

