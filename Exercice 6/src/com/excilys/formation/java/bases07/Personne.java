package com.excilys.formation.java.bases07;

public class Personne {

	protected String nom;
	
	public Personne(String prenom){
		this.nom=prenom;
	}
	
	public void Hello(){
		System.out.println("Hello "+ nom);
		
	}
	
}
