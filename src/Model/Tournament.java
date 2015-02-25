package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import View.View;
import View.View_console;

public class Tournament {
	private List<Round> list_round;

	public Tournament() {
		this.list_round = new ArrayList<Round>();
	}
	
	public void add_round(Round round){
		this.list_round.add(round);
	}
	
	public Round get_last_round(){
		Round last_round = this.list_round.get(list_round.size()-1);
		return last_round;
	}
	
	public boolean start(){
		View consoleview = new View_console();
		Round new_round = new Round();
		Round last_round = this.get_last_round();
		if (last_round.get_list_tab_team().size() % 2 == 0){
			new_round = this.even_round(last_round);
		}
		else{
			new_round = this.odd_round(last_round);
		}
		this.add_round(new_round);
		consoleview.print_round(new_round);
		
		if(new_round.get_list_tab_team().size()==1){
			for(Team a[]: new_round.get_list_tab_team()){
				if(a.length == 1){
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
	} 
	
	
	public Round even_round(Round last_round){
		Round new_round;
		List<Team> list_team = new ArrayList<Team>();
		Scanner sc = new Scanner(System.in);
		for(Team a[]:last_round.get_list_tab_team()){
			if(a.length == 2){
				System.out.println("Team "+a[0].get_name()+" VS "+"Team "+a[1].get_name());
				System.out.println("Who won ?");
				String input;
				boolean flag = false;
				do {
					input = sc.nextLine();
					if (last_round.get_team_by_name(input) != null){
						String name_team = last_round.get_team_by_name(input).get_name();
						if(name_team ==  a[0].get_name() || name_team ==  a[1].get_name()){
							list_team.add(last_round.get_team_by_name(input));
							flag = true;
						}
						else System.out.println("Not valid");
					}
					else System.out.println("Not valid");
				} while (flag == false);
			}
			else{
				System.out.println("Team "+a[0].get_name()+" passed the round due to odd number of team :");
				list_team.add(a[0]);
			}
		}
		new_round = new Round(list_team);
		return new_round;
	}
	
	public Round odd_round(Round last_round){
		Round new_round;
		List<Team> list_team = new ArrayList<Team>();
		Scanner sc = new Scanner(System.in);
		if (last_round.get_type() == true){
			for(Team a[]:last_round.get_list_tab_team()){
				System.out.println("Team "+a[0].get_name()+" VS "+"Team "+a[1].get_name());
				System.out.println("Who won ?");
				String input;
				boolean flag = false;
				do {
					input = sc.nextLine();
					if (last_round.get_team_by_name(input) != null){
						String name_team = last_round.get_team_by_name(input).get_name();
						if(name_team ==  a[0].get_name() || name_team ==  a[1].get_name()){
							list_team.add(last_round.get_team_by_name(input));
							flag = true;
						}
						else System.out.println("Not valid");
					}
					else System.out.println("Not valid");
				} while (flag == false);
			}
		}
		else {
			int i = 0;
			for(Team a[]:last_round.get_list_tab_team()){
				if (i == last_round.get_list_tab_team().size()-2){
					System.out.println("Only these team will fight due to odd number of team : ["+a[0].get_name()+" / "+a[1].get_name()+" ]");
					System.out.println("Team "+a[0].get_name()+" VS "+"Team "+a[1].get_name());
					System.out.println("Who won ?");
					String input;
					boolean flag = false;
					do {
						input = sc.nextLine();
						if (last_round.get_team_by_name(input) != null){
							String name_team = last_round.get_team_by_name(input).get_name();
							if(name_team ==  a[0].get_name() || name_team ==  a[1].get_name()){
								list_team.add(last_round.get_team_by_name(input));
								flag = true;
							}
							else System.out.println("Not valid");
						}
						else System.out.println("Not valid");
					} while (flag == false);
				}
				else {
					if(a.length == 2){
						list_team.add(last_round.get_team_by_name(a[0].get_name()));
						list_team.add(last_round.get_team_by_name(a[1].get_name()));
					}
					else{
						list_team.add(last_round.get_team_by_name(a[0].get_name()));
					}
				}
				i++;
			}
		}
		new_round = new Round(list_team);
		return new_round;
	}
}
