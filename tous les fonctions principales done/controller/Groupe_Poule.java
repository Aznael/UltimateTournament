package com.ManagerTournament.controller;

import java.util.ArrayList;
import java.util.List;



import com.ManagerTournament.models.Poule;
import com.ManagerTournament.models.Team;
import com.ManagerTournament.view.View;


public class Groupe_Poule {
	// constant
	//
	final int NBER_MAX = 4;
	public List<Team> getList_team() {
		return list_team;
	}

	public void setList_team(List<Team> list_team) {
		this.list_team = list_team;
	}
	//
	// attributes
	//
	private List<Poule> Pouletab;
	private List<Team> list_team;
	private View view_type;
	private List<Team> cadeau_roman_lovelove;
	
	//
	// constructors
	//
	public Groupe_Poule(View view) {
		Pouletab = new ArrayList<>();
		list_team = new ArrayList<>();
		cadeau_roman_lovelove= new ArrayList<>();
		this.view_type=view;
		
	}

	//
	// methods
	//

	// recupere la liste venant du main
	public void set_list_team(List<Team> ajoute_poule) {
		this.list_team.addAll(ajoute_poule);

	}

	public void initialization_group_pool() {
		if (list_team.size() > 5) {
			int position = 0;
			int miss_team = (NBER_MAX - (list_team.size() % NBER_MAX)) % NBER_MAX;
			int nber_pool = list_team.size() / NBER_MAX;
			if (miss_team != 0) {
				nber_pool++;
			}

			int parcours1 = miss_team;
			int parcours2 = nber_pool - miss_team;
			while (parcours1 != 0) {
				// initialize pool with 3 people
				this.initialize_pool(position, 3);
				parcours1--;
				position = position + 3;

			}
			while (parcours2 != 0) {
				// initialize pool with 4 people
				this.initialize_pool(position, 4);
				parcours2--;
				position = position + 4;

			}

		}
		else{
			view_type.error_message_team_number();
		}
		
	}

	// initialisation d une poule de 3 ou 4
	
	public void initialize_pool(int position_team, int number_team) {
		Poule pool;
		ArrayList<Team> list = new ArrayList<Team>();
		for (int i = 0; i < number_team; i++) {
			list.add(list_team.get(position_team));
			position_team++;
		}
		pool = new Poule(list);
		Pouletab.add(pool);
	}

	// afficher
	
//	public void display_list_console() {
//		System.out.println("Ensemble des equipes :");
//		for (int i = 0; i < list_team.size(); i++) {
//			System.out.println("- equipe " + list_team.get(i).getName());
//		}
//	}
	
	public List<Poule> getPouletab() {
		return Pouletab;
	}

	public void setPouletab(List<Poule> pouletab) {
		Pouletab = pouletab;
	}


	public void create_teams_list(int nbr_equipe){
		List<Team> equipe = new ArrayList<Team>();
		for (int i=0; i<nbr_equipe; i++){
			Team a = new Team(Integer.toString(i));
			equipe.add(a);
		}
		this.set_list_team(equipe);
	}
	public ArrayList<Team> get_winner(Poule poule_selec){
		Team comparateur1;
		Team comparateur2;
		ArrayList<Team> teamtab = poule_selec.getTeamtab();
		if(teamtab.get(0).calculate_score() > teamtab.get(1).calculate_score()){
			comparateur1 = teamtab.get(0);
			comparateur2  = teamtab.get(1);
		}
		else{
			comparateur1 = teamtab.get(1);
			comparateur2 = teamtab.get(0);
		}
		for(int i = 2; i < poule_selec.get_size(); i++){
			if(comparateur2.calculate_score() < teamtab.get(i).calculate_score() ||
					comparateur2.calculate_score() == teamtab.get(i).calculate_score() && comparateur2.getGoalaverage() < teamtab.get(i).getGoalaverage() ){
				if(comparateur1.calculate_score() < teamtab.get(i).calculate_score() ||
						comparateur1.calculate_score() == teamtab.get(i).calculate_score() && comparateur1.getGoalaverage() < teamtab.get(i).getGoalaverage()){
					comparateur2 = comparateur1;
					comparateur1 = teamtab.get(i);
					
				}
				else{
					comparateur2 = teamtab.get(i);
				}
			}
		}
		ArrayList <Team> result= new ArrayList<Team>();
		result.add(comparateur1);
		result.add(comparateur2);
		return result;
		
		
	}
	public void deroulement_round(Poule poule_selec){
		int score1 = 0;
		int score2 = 0;
		ArrayList<Team> teamtab = poule_selec.getTeamtab();
		int parcours1 = 0;
		int parcours2 = parcours1+1;
		while(parcours1 < teamtab.size()-1){
			while(parcours2 < teamtab.size()){
				view_type.display_versus(teamtab.get(parcours1).getName(),teamtab.get(parcours2).getName());
				//saisie des score par team 
				//
				score1 =view_type.fill_in_score(teamtab.get(parcours1).getName());
				
		
				score2 =view_type.fill_in_score(teamtab.get(parcours2).getName());
				//
				// affichage score
				//
				view_type.display_score(teamtab.get(parcours1).getName(), teamtab.get(parcours2).getName(), score1, score2);
				
				//
				teamtab.get(parcours1).set_win_lose_goalaverage(teamtab.get(parcours2), score1, score2);
				parcours2++;
			}	
			
			parcours1++;
			parcours2=parcours1+1;
		}
		poule_selec.setWinners(this.get_winner(poule_selec));
		view_type.display_winners(poule_selec);
		
	}

	public List<Team> getCadeau_roman_lovelove() {
		return cadeau_roman_lovelove;
	}

	public void setCadeau_roman_lovelove(List<Team> cadeau_roman_lovelove) {
		this.cadeau_roman_lovelove.addAll(cadeau_roman_lovelove);
	}
	
	public void last_setting_winners(){
		for(int i = 0; i< Pouletab.size(); i++){
			this.setCadeau_roman_lovelove(Pouletab.get(i).getWinners());
		}
	}
	
	

}
