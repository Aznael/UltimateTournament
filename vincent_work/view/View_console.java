package com.ManagerTournament.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ManagerTournament.models.Team;

public class View_console extends View{

	private Scanner sc = new Scanner(System.in);
	
	
	//error message
	public void error_message_team_number(){
		System.out.println("Less than 5 teams, it's not enough team for the pool mode");
	}
	public void afficher_organisation(ArrayList<Team> tab_team){

		int parcours1 = 0;
		int parcours2 = parcours1+1;
		while(parcours1 < tab_team.size()-1){
			while(parcours2 < tab_team.size()){
				System.out.println("Team "+tab_team.get(parcours1).getName() +" contre la team "+tab_team.get(parcours2).getName());
				parcours2++;
			}	
			
			parcours1++;
			parcours2=parcours1+1;
		}
	
	}
	public int select_teams_number_pool(){
		System.out.println("Combien d'équipe ?");
		
		int nbr_equipe;
		do{
		String str = sc.nextLine();
		nbr_equipe = Integer.parseInt(str);
		}while(nbr_equipe < 6);
		return nbr_equipe;
	}
	public void display_list_console(List<Team> list_team){
		System.out.println("Ensemble des equipes :");
		for (int i = 0; i < list_team.size(); i++) {
			System.out.println("- equipe " + list_team.get(i).getName());
		}
	}
	public void close_scanner(){
		sc.close();
	}
	public String choice_user(){
		
		System.out.println("Menu du tournoi avec poule");
		System.out.println("help : explication about the software");
		System.out.println("0 : close the software");
		System.out.println("1 :Modification of the team information");
		System.out.println("2 :Beginning of the matches pool ");
		return sc.nextLine();
	}
	public void display_case_help(){
		System.out.println("you will never have help");
	}
	public void display_case_1(){
		System.out.println("Modification des informations d'une team");
		System.out.println("Choix de la team à modif, les afficher ?(y/n)");
	}
	public void display_case_2(){
		System.out.println("Lancement du tournoi");
	}
	public void display_case_default(){
		System.out.println("f*ck");
	}
	public void display_close_software(){
		System.out.println("Sortie du programme");
	}
}
