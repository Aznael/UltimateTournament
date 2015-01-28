package com.excilys.formation.java.bases07;

public class Espagnole extends Personne{

	public void Hello(){
		System.out.println("Hola "+super.nom);
	}
	public Espagnole(String nom){
		super(nom);
	}
}
