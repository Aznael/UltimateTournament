package Controller;

import java.util.List;

import Model.Groupe_Poule;
import Model.Team;
import Model.Tournament;
import View.View;

public class Controller {
	private Tournament t;
	private Groupe_Poule gp;
	private View view;
	
	public Controller(Groupe_Poule gp, View view) {
		this.gp = gp;
		this.view = view;
	}
	
	public Controller(Tournament t){
		this.t = t;
	}


	public List <Team> start_groupe_poule(){
		int nbr_equipe = view.select_teams_number_pool();
		this.gp.create_teams_list(nbr_equipe);
		this.view.display_list(gp.getList_team());
		
		String input = "";
		while(input != "0"){
			
			input = this.view.choice_user();
			switch(input) {
				case "help":
					this.view.display_case_help();
					break;
				case "0":
					this.view.display_close_software();
					input = "0";
					break;
					
				case "1":
					view.display_case_1();
					
					view.choice_team_modification(gp);
					break;
				case "2": 
					view.display_case_2();
					gp.initialization_group_pool();
					view.display_all_pool(gp.getPouletab());
					for(int i = 0 ; i < gp.getPouletab().size(); i++){
						gp.deroulement_round(gp.getPouletab().get(i));
						
					}
					gp.last_setting_winners();
					view.display_all_winners(gp.getCadeau_roman_lovelove());
					List<Team> list_winner = gp.get_end_winner();
					return list_winner;
				default:
					view.display_case_default();
					break;
					
			}
			
		}
		return null;
	}
	
}
