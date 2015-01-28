package com.excilys.formation.java.bases07;

public class Italien extends Personne{
	public void Hello(){
		System.out.println("Ciao "+super.nom);
	}
	public Italien(String nom){
		super(nom);
	}
}
