package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainScreen extends JPanel{
	
	Buttons ms = new Buttons();
	Calender cal = new Calender();
	Sidebar sb = new Sidebar();
	
	public MainScreen(){
		setLayout(new BorderLayout());
		add(ms,BorderLayout.NORTH);
		add(cal,BorderLayout.CENTER);
		add(sb,BorderLayout.WEST);
	}
}
