package com.example.hafnessbanque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	@ManyToMany
	@JoinTable(name="EMP_GR")
	private Collection<Groupe> groupes;
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
