package com.ManagerTournament.view;

import java.util.List;

import com.ManagerTournament.controller.Groupe_Poule;
import com.ManagerTournament.models.Poule;
import com.ManagerTournament.models.Team;

public abstract class View {

	
	
	public abstract void error_message_team_number();
	public abstract int select_teams_number_pool();
	public abstract void display_list(List<Team> list_team);
	public abstract String choice_user();
	public abstract void close_scanner();
	public abstract void display_case_help();
	public abstract void display_case_1();
	public abstract void display_case_2();
	public abstract void display_case_default();
	public abstract void display_close_software();
	public abstract void display_winners(Poule display_pool);
	public abstract void display_all_pool(List<Poule> all_pool);
	public abstract void display_versus(String team1, String team2);
	public abstract int	fill_in_score(String team);
	public abstract Team choice_team_modification(Groupe_Poule gp);
	public abstract void display_score(String team1, String team2, int score1, int score2);
	public abstract void display_all_winners(List<Team> winners);
	//public abstract void afficher_organisation(List<Team> tab_team);
}
