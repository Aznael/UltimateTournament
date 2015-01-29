package Base;

import java.util.List;

public class Team {
	String name;
	String desc;
	List<Player> list_player; 
	
	//Constructor
	//
	public Team(String name) {
		this.name = name;
	}
	//
	
	//Methode
	//
	public void print_name(){
		System.out.println(this.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Player> getList_player() {
		return list_player;
	}

	public void setList_player(List<Player> list_player) {
		this.list_player = list_player;
	}
	//
	
}