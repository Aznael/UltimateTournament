package com.ManagerTournament;

import com.ManagerTournament.controller.Groupe_Poule;
import com.ManagerTournament.view.View;
import com.ManagerTournament.view.View_console;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		View view;
		view = new View_console();
		Groupe_Poule gp = new Groupe_Poule(view);
		int nbr_equipe = view.select_teams_number_pool();
		gp.create_teams_list(nbr_equipe);
		view.display_list(gp.getList_team());
		
		String input = "";
		while(input != "0"){
			
			input = view.choice_user();
			switch(input) {
				case "help":
					view.display_case_help();
					break;
				case "0":
					view.display_close_software();
					input = "0";
					break;
					
				case "1":
					view.display_case_1();
					
					view.choice_team_modification(gp);
					/*
					System.out.println("Entrez le nom");
					
					//String team_to_change = sc.nextLine();
					
					
					switch(input2) {
						case "help":
							break;
						case "1":
							System.out.println("Modification du nom");
							break;
						case "2" : 
							System.out.println("Modification du nombre de team");
							break;
						default:
							System.out.println("nop");
							break;
					
					
					}
					*/
					
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
					break;
				default:
					view.display_case_default();
					break;
					
			}
			
		}
		view.close_scanner();

	}

}
