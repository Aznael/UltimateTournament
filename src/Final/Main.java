package Final;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("Combien d'équipe ?");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int nbr_equipe = Integer.parseInt(str);
		
		List<Team> list_team = new ArrayList<Team>();
		for (int i=0; i<nbr_equipe; i++){
			Team a = new Team(Integer.toString(i));
			list_team.add(a);
		}

		Round round = new Round(list_team);
		Tournament t = new Tournament();
		t.add_round(round);
		round.print_round();
		
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
						t.get_last_round().print_round();
						input = "0";
					}
					break;
				default:
					System.out.println("nop");
					break;
			}
		}
	}

}
