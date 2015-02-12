package com.ManagerTournament.models;

import java.util.ArrayList;




public class Poule {
	//attributs
	ArrayList<Team> teamtab;
	ArrayList<Team> winners;
	//constructeurs
	//
	public Poule(ArrayList<Team> teams){
		teamtab= new ArrayList<>();
		winners= new ArrayList<>();
		teamtab.addAll(teams);

		
	}
//	public ArrayList<Team> get_winner(){
//		Team comparateur1;
//		Team comparateur2;
//		if(teamtab.get(0).calculate_score() > teamtab.get(1).calculate_score()){
//			comparateur1 = teamtab.get(0);
//			comparateur2  = teamtab.get(1);
//		}
//		else{
//			comparateur1 = teamtab.get(1);
//			comparateur2 = teamtab.get(0);
//		}
//		for(int i = 2; i < this.get_size(); i++){
//			if(comparateur2.calculate_score() < teamtab.get(i).calculate_score() ||
//					comparateur2.calculate_score() == teamtab.get(i).calculate_score() && comparateur2.getGoalaverage() < teamtab.get(i).getGoalaverage() ){
//				if(comparateur1.calculate_score() < teamtab.get(i).calculate_score() ||
//						comparateur1.calculate_score() == teamtab.get(i).calculate_score() && comparateur1.getGoalaverage() < teamtab.get(i).getGoalaverage()){
//					comparateur2 = comparateur1;
//					comparateur1 = teamtab.get(i);
//					
//				}
//				else{
//					comparateur2 = teamtab.get(i);
//				}
//			}
//		}
//		ArrayList <Team> result= new ArrayList<Team>();
//		result.add(comparateur1);
//		result.add(comparateur2);
//		return result;
//		
//		
//	}
	//
	//methods
	
	public int get_size(){
		return teamtab.size();
	}
	//affiche l'ensemble des matchs qui vont se jouer !!
//	public void afficher_organisation(){
//
//		int parcours1 = 0;
//		int parcours2 = parcours1+1;
//		while(parcours1 < teamtab.size()-1){
//			while(parcours2 < teamtab.size()){
//				System.out.println("Team "+teamtab.get(parcours1).getName() +" contre la team "+teamtab.get(parcours2).getName());
//				parcours2++;
//			}	
//			
//			parcours1++;
//			parcours2=parcours1+1;
//		}
//	
//	}

	//déroulement de tous les matchs de poule
	
	

	public ArrayList<Team> getTeamtab() {
		return teamtab;
	}
	public void setTeamtab(ArrayList<Team> teamtab) {
		this.teamtab = teamtab;
	}
	public ArrayList<Team> getWinners() {
		return winners;
	}
	public void setWinners(ArrayList<Team> newWinners) {
		this.winners.addAll(newWinners);
	}
	
}
