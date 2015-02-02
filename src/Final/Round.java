package Final;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Round {
	//Attributs
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
	
	public void print_round(){
		for(Team a[]:this.list_tab_team){
			System.out.print("[");
			if(a.length == 1){
				a[0].print_name();
			}
			else{
				for(int i=0; i<a.length;i++){
					if(i == a.length-1){
						System.out.print(" / ");
					}
					a[i].print_name();
				}
			}
			System.out.print("]");
		}
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
	
	public void change_name_team(){
		Scanner sc = new Scanner(System.in);
		String team_to_change;
		
		System.out.println("You will change the name of a team");
		this.print_round();
		
		
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
		
		
		this.print_round();
	}
	//

}
