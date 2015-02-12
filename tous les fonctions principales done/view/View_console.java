package com.ManagerTournament.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ManagerTournament.controller.Groupe_Poule;
import com.ManagerTournament.models.Poule;
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
		nbr_equipe = sc.nextInt();
		}while(nbr_equipe < 6);
		return nbr_equipe;
	}
	public void display_list(List<Team> list_team){
		System.out.println("Ensemble des equipes :");
		for (int i = 0; i < list_team.size(); i++) {
			System.out.println("- equipe"+i+"  : " + list_team.get(i).getName());
		}
	}
	public void close_scanner(){
		sc.close();
	}
	public String choice_user(){
		
		System.out.println("Tournament menu with pool");
		System.out.println("help : explication about the software");
		System.out.println("0 : close the software");
		System.out.println("1 :Modification of the team information");
		System.out.println("2 :Beginning of the matches pool ");
		String choice = sc.nextLine();
		return choice;
	}
	public void display_case_help(){
		System.out.println("you will never have help");
	}
	public void display_case_1(){
		System.out.println("Modification des informations d'une team");
		
	}
	public void display_case_2(){
		System.out.println("Beginning of the tournament");
	}
	public void display_case_default(){
		System.out.println("f*ck");
	}
	public void display_close_software(){
		System.out.println("Exit software");
	}
	public void display_team(ArrayList<Team> teamtab){
		System.out.println("The teams are :");
		for(int i=0; i < teamtab.size(); i++){
			System.out.println("- team :"+ teamtab.get(i).getName());
		}
	}
	public void display_winners(Poule display_pool){
		List<Team> display_winners= display_pool.getWinners();
		System.out.println("The winners are : ");
		System.out.println("The first team : "+display_winners.get(display_winners.size() - 2).getName());
		System.out.println("The Second team : "+display_pool.getWinners().get(display_winners.size() - 1).getName());
	}
	public void display_all_pool(List<Poule> all_pool){
		
		for(int i = 0; i < all_pool.size(); i++){
			System.out.println("Pool "+ i +" : " );
		this.display_team(all_pool.get(i).getTeamtab());
		}

	}
	public void display_versus(String team1, String team2){
		System.out.println("Team "+team1 +" versus team "+team2);
	}
	public int	fill_in_score(String team){
		System.out.println("Entrez le score de la team "+ team +" : ");
		return sc.nextInt();
	}
	public Team choice_team_modification(Groupe_Poule gp){
		int input;
		do{
		System.out.println("Quelle équipe voulez-vous changer ? \n");
		this.display_list(gp.getList_team());
		
		input = sc.nextInt();
		
		}while(input <0 || input > gp.getList_team().size());
		System.out.println("Vous avez choisi la team :  "+gp.getList_team().get(input).getName() );
		return gp.getList_team().get(input);
	}
	//putain je fais ca comment !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void clear_scanner(){
		sc.nextLine();
	}
	public void display_score(String team1, String team2, int score1, int score2){
		System.out.println(" equipe"+team1+" : "+ score1+ " | "+ score2+" : equipe  "+ team2 );
	}
	public void display_all_winners(List<Team> winners){
		System.out.println("Les vainqueurs des poules sont :  ");
		this.display_list(winners);
	}
}






