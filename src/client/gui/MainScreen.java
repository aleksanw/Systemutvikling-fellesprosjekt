package client.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

class MainScreen extends JPanel {

	Buttons ms = new Buttons();
	Calendar cal = new Calendar();
	Sidebar sb = new Sidebar();

	public MainScreen() {
		setLayout(new BorderLayout());
		add(ms, BorderLayout.NORTH);
		add(cal, BorderLayout.CENTER);
		add(sb, BorderLayout.WEST);
	}
	
	public void refresh() {
		
	}
}
