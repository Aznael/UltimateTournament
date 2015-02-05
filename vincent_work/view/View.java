package com.ManagerTournament.view;

import java.util.ArrayList;
import java.util.List;

import com.ManagerTournament.models.Team;

public abstract class View {

	
	
	public abstract void error_message_team_number();
	public abstract void afficher_organisation(ArrayList<Team> tab_team);
	public abstract int select_teams_number_pool();
	public abstract void display_list_console(List<Team> list_team);
	public abstract String choice_user();
	public abstract void close_scanner();
	public abstract void display_case_help();
	public abstract void display_case_1();
	public abstract void display_case_2();
	public abstract void display_case_default();
	public abstract void display_close_software();
	
}
