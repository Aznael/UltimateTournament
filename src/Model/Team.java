package Model;

import java.util.List;

import Model.Team;

public class Team {
	private String name;
	private String desc;
	private List<Player> list_player; 
	//la premiere colonne correspond au nombre de victoire 
	//la deuxième colonne correspond au nombre de défaite
	//la troisième colonne correspond au nombre de match nul
	int score[]= new int[3];
	int goalaverage=0;
	
	/*
	//Constructor
	//
	public Team(String name) {
		this.name = name;
	}
	//
	*/
	public Team(String name) {
		this.name = name;
		goalaverage = 0;
		for(int i=0; i<3;i++){
			score[i]=0;
		}
	}
	//
	
	//Methods
	//
	public void print_name(){
		System.out.print(this.name);
	}

	public String get_name(){
		return this.name;
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
	
	public int[] getscore(){
		return score;
	}
	
	public void win_game(){
		score[0]++;
	}
	public void lose_game(){
		score[1]++;
	}
	public void tied_game(){
		score[2]++;
	}
	public void set_win_lose_goalaverage( Team team2, int scoreteam1, int scoreteam2){
		if(scoreteam1 > scoreteam2){
			this.win_game();
			team2.lose_game();
		}
		else if(scoreteam1 < scoreteam2){
			this.lose_game();
			team2.win_game();
		}
		else{
			this.tied_game();
			team2.tied_game();
		}
		this.setGoalaverage(scoreteam1 - scoreteam2);
		team2.setGoalaverage(scoreteam2 - scoreteam1);
	}
	
	public int calculate_score(){
		return score[0]*3+ score[2];
	}
	public int getGoalaverage() {
		return goalaverage;
	}

	public void setGoalaverage(int goalaverage_match) {
		this.goalaverage = goalaverage_match + this.goalaverage;
	}
	//
	
}
