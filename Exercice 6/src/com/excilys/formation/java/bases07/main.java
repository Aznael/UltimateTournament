package com.excilys.formation.java.bases07;

import java.util.Scanner;

public class main {

	
	public static void main(String[] String ) {
		System.out.println("Entrer votre prénom :");
		Scanner sc= new Scanner(System.in);
		String nom=sc.nextLine();
		int pays;
		do{
			System.out.println("Choisissez votre pays :");
			System.out.println("-1 france");
			System.out.println("-2 Italie");
			System.out.println("-3 Espagne");
			pays= sc.nextInt();
		
		}while(pays != 1 && pays != 2 && pays != 3);
		
		Personne personne; 
		switch(pays){
		
		case 1 :
			personne = new Francais(nom);
			
		break;
		case 2 :
			personne = new Italien(nom);
			
		break;
		
		case 3 :
			personne =new Espagnole(nom);
			
		break;
		
		default :
			System.out.println("ERROR");
		break;
		
		
		}
		sayHello(personne);
			 
		
	}
		public static void sayHello(Personne personne){
			personne.Hello();
		}

}
