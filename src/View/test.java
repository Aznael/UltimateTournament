package View;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class test extends JFrame implements ActionListener{

	private JButton b1;
	private String str = "caca";

	public test(){
		setTitle("test");
		setSize(300,200);
		b1 = new JButton("test");
		Container contenu = this.getContentPane();
		contenu.setLayout(new FlowLayout());
		contenu.add(b1);
		b1.addActionListener(this);
	}
	
	
	public String getStr() {
		return str;
	}


	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getStr());
	}
	
}
