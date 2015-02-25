package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Groupe_Poule;
import Model.Round;
import Model.Team;
import Model.Tournament;
import View.View;
import View.View_console;
import View.View_graphique;
import View.test;

public class Main {

	public static void main(String[] args) {
		System.out.println("Graphique : 1, Console : 2");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Round round;
		if (str.equals("2")) {
			View view = new View_console();
			System.out.println("Poule ou DM ?");
			str = sc.nextLine();
			if (str.equals("Poule")) {
				Groupe_Poule gp = new Groupe_Poule(view);
				Controller controller = new Controller(gp, view);
				List <Team> list_winner = controller.start_groupe_poule();
				round = new Round(list_winner);
			}
			else{
				System.out.println("Combien d'équipe ?");
				str = sc.nextLine();
				int nbr_equipe = Integer.parseInt(str);
				
				List<Team> list_team = new ArrayList<Team>(); 
				for (int i=0; i<nbr_equipe; i++){
					Team a = new Team(Integer.toString(i));
					list_team.add(a);
				}
				round = new Round(list_team);
			}
			Tournament t = new Tournament();
			t.add_round(round);
			view.print_round(round);
			System.out.println("\n0 : exit\n1 : Change name\n2 : Start the round\nhelp : Print the help\n");
			String input = "";
			while(input != "0"){
				input = sc.nextLine();
				switch(input) {
					case "help":
						System.out.println();
						break;
					case "0":
						System.out.println("Sortie du programme");
						input = "0";
						break;
					case "1":
						t.get_last_round().change_name_team();
						break;
					case "2":
						if(t.start()==true){
							System.out.print("And the winner is : ");
							view.print_round(t.get_last_round());
							input = "0";
						}
						break;
					default:
						System.out.println("nop");
						break;
				}
			}
		}
		else{
			View_graphique view = new View_graphique();
			view.setVisible(true);
		}
	}
}
	
