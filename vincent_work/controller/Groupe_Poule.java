package com.ManagerTournament.controller;

import java.util.ArrayList;
import java.util.List;

import com.ManagerTournament.models.Poule;
import com.ManagerTournament.models.Team;
import com.ManagerTournament.view.View;
import com.ManagerTournament.view.View_console;

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
	//
	// constructors
	//
	public Groupe_Poule(View view) {
		Pouletab = new ArrayList<>();
		list_team = new ArrayList<>();
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
	
	public void display_list_console() {
		System.out.println("Ensemble des equipes :");
		for (int i = 0; i < list_team.size(); i++) {
			System.out.println("- equipe " + list_team.get(i).getName());
		}
	}
	
	public List<Poule> getPouletab() {
		return Pouletab;
	}

	public void setPouletab(List<Poule> pouletab) {
		Pouletab = pouletab;
	}

	public void display_all_pool_console(){
		for(int i = 0; i < Pouletab.size(); i++){
			System.out.println("Poule "+ i +" : " );
			Pouletab.get(i).display_team();
		}
	}
	public void create_teams_list(int nbr_equipe){
		List<Team> equipe = new ArrayList<Team>();
		for (int i=0; i<nbr_equipe; i++){
			Team a = new Team(Integer.toString(i));
			equipe.add(a);
		}
		this.set_list_team(equipe);
	}

}
