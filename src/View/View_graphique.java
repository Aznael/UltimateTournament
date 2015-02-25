package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Round;
import Model.Team;
import Model.Tournament;

public class View_graphique extends JFrame implements ActionListener{
	private JButton b1, b2;
	private JLabel label;
	private JButton list_button[];
	private JTextField saisie;
	private String str_nbr_team;
	
	public View_graphique(){
		this.setTitle("Choix du type de tournoi : ");
		this.setSize(300,200);
		b1 = new JButton("Poule");
		b2 = new JButton("DM");
		Container contenu = this.getContentPane();
		contenu.setLayout(new FlowLayout());
		contenu.add(b1);
		contenu.add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public String get_nbr_team(){
		return this.str_nbr_team;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = e.getActionCommand();
		if(nom.equals("DM")){
			Round round;
			View view = new View_console();
			
			
			View_graphique_nbr_team vgnbt = new View_graphique_nbr_team(this);
			this.str_nbr_team = vgnbt.recup_nrb_team();
			if(str_nbr_team != null){
				System.out.println(str_nbr_team);
			}
			else System.out.println("sorti");
			vgnbt.dispose();
			
			int nbr_team = Integer.parseInt(this.str_nbr_team);
			List<Team> list_team = new ArrayList<Team>(); 
			for (int i=0; i<nbr_team; i++){
				Team a = new Team(Integer.toString(i));
				list_team.add(a);
			}
			round = new Round(list_team);
			Tournament t = new Tournament();
			t.add_round(round);
			view.print_round(round);
			
		}
		else if(nom.equals("ok")){
			int nbr_team = Integer.parseInt(saisie.getText());
			System.out.println(nbr_team);
		}
	}
	

}

class View_graphique_nbr_team extends JDialog implements ActionListener{

	private boolean ok;
	private JButton okBouton;
	private JTextField champTexte;

	public View_graphique_nbr_team(JFrame proprio){
		super (proprio, "Saisie du nbr de team", true);
		setSize(250, 120);
		okBouton = new JButton("OK");
		champTexte = new JTextField(20);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		contenu.add(okBouton);
		contenu.add(champTexte);
		
		okBouton.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okBouton){
			ok = true; this.setVisible(false);
		}
	}
	
	public String recup_nrb_team(){
		ok = false;
		this.setVisible(true);
		if (ok) return champTexte.getText();
			else return null;
	}
}

class View_graphique_dm extends JDialog implements ActionListener{

	private boolean ok;
	private JButton okBouton;
	private JButton list_button[];
	private JTextField champTexte;

	public View_graphique_dm(JFrame proprio){
		super (proprio, "Tournament DM", true);
		Round round;
		View view = new View_console();
		setSize(400, 250);
		okBouton = new JButton("OK");
		champTexte = new JTextField(20);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		contenu.add(okBouton);
		contenu.add(champTexte);
		okBouton.addActionListener(this);
		
		int nbr_team = Integer.parseInt(((View_graphique) proprio).get_nbr_team());
		List<Team> list_team = new ArrayList<Team>(); 
		for (int i=0; i<nbr_team; i++){
			Team a = new Team(Integer.toString(i));
			list_team.add(a);
		}
		round = new Round(list_team);
		Tournament t = new Tournament();
		t.add_round(round);
		view.print_round(round);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okBouton){
			ok = true; this.setVisible(false);
		}
		else{
			
		}
	}
	
	public String recup_nrb_team(){
		ok = false;
		this.setVisible(true);
		if (ok) return champTexte.getText();
			else return null;
	}
}