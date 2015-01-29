package Base;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

	private String type;
	private List<Team> team_list;
	
	public Tournament() {
		this.team_list = new ArrayList<Team>();
	}
	
	public void add_team(Team vteam){
		this.team_list.add(vteam);
	}
	
	public void print_team(){
		for(Team a:this.team_list){
			a.print_name();
		}
	}

}