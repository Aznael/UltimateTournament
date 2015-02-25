package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import View.View;
import View.View_console;


public class Round {
	//Attributes
	//
	private List <Team[]> list_tab_team;
	// true even, false odd
	private boolean type;
	//
	
	
	//Method
	//
	public List <Team[]> get_list_tab_team(){
		return this.list_tab_team;
	}
	
	public boolean get_type(){
		return this.type;
	}
	public Round(){
		
	}
	
	public Round(List<Team> list_team) {
		this.list_tab_team = new ArrayList<Team[]>();
		
		//Winner
		if (list_team.size() == 1){
			Team tab[] = new Team[1];
			tab[0] = list_team.get(0);
			this.list_tab_team.add(tab);
		}
		//Even OR Final
		else if (list_team.size() % 2 == 0 || list_team.size() == 2){
			this.type = true;
			for(int i=0;i<list_team.size();i++){
				Team tab[] = new Team[2];
				tab[0] = list_team.get(i);
				tab[1] = list_team.get(i+1);
				this.list_tab_team.add(tab);
				i++;
			}
		}
		//Odd
		else{
			this.type = false;
			int reste = list_team.size() % 2;
			int regular = list_team.size()-reste;
			
			for(int i=0;i<regular;i++){
				Team tab[] = new Team[2];
				tab[0] = list_team.get(i);
				tab[1] = list_team.get(i+1);
				this.list_tab_team.add(tab);
				i++;
			}
			
			for (int i = regular;i<list_team.size();i++){
				Team tab[] = new Team[1];
				tab[0] = list_team.get(i);
				this.list_tab_team.add(tab);
			}
		}
		
		
		
		/*
		//even team
		else if (list_team.size() % 2 == 0){
			this.type = true;
			for(int i=0;i<=(list_team.size())/2;i++){
				Team tab[] = new Team[2];
				tab[0] = list_team.get(i);
				tab[1] = list_team.get(i+1);
				this.list_tab_team.add(tab);
				i++;
			}
		}
		//odd team
		else{
			this.type = false;
			for(int i=0;i<=(list_team.size()-1)/2;i++){
				Team tab[] = new Team[2];
				tab[0] = list_team.get(i);
				tab[1] = list_team.get(i+1);
				this.list_tab_team.add(tab);
				i++;
			}
			Team tab[] = new Team[1];
			tab[0] = list_team.get(list_team.size()-1);
			this.list_tab_team.add(tab);
		}
		*/
	}	
	
	public Team get_team_by_name(String name_team){
		for(Team a[]:this.list_tab_team){
			for(Team b:a){
				if(b.get_name().equals(name_team)){
					return b;
				}
			}
		}
		return null;
	}
	
	public Team[] get_penultieme_tab_team(){
		Team[] tab_team = new Team[2];
		int size = this.get_list_tab_team().size();
		int i = 0;
		for(Team[] a:this.get_list_tab_team()){
			if (i == size - 2){
				tab_team[0] = a[0];
				tab_team[1] = a[1];
			}
			i++;
		}
		return tab_team;
	}
	
	public void print_penultieme_team(){
		for (Team a:this.get_penultieme_tab_team()){
			a.print_name();
		}
	}
	
	public void change_name_team(){
		Scanner sc = new Scanner(System.in);
		String team_to_change;
		View consoleview = new View_console();
		System.out.println("You will change the name of a team");
		
		while(true) {
			System.out.println("Which team do you want to change ?");
			team_to_change = sc.nextLine();
			if(this.get_team_by_name(team_to_change) == null){
				System.out.println("This team doesn't exist");
			}
			else break;
		}
		
		int flag = 0;
		do{
			System.out.println("What's her new name ?");
			String new_name = sc.nextLine();
			
			if(this.get_team_by_name(new_name) != null){
				System.out.println("This name is already used, sorry");
			}
			else{
				for(Team a[]:this.list_tab_team){
					for(Team b:a){
						if(b.get_name().equals(team_to_change)){
							b.setName(new_name);
							flag =1;
						}
					}
				}
			}
		}while(flag == 0);
		
		
		consoleview.print_round(this);
	}
	//

}
