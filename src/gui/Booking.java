package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Booking extends JPanel {
	
	protected JLabel label;
	protected JLabel date;
	protected JList list;
	protected JScrollPane scroll;
	
	GridBagConstraints g = new GridBagConstraints();
	
	public Booking(){
		setLayout(new GridBagLayout());
		
		label = new JLabel();
		label.setText("Ledige og ikke ledige rom ");
		
		date = new JLabel();
		
		list = new JList();
		
		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setSize(150, 150);

		g.fill = GridBagConstraints.BOTH;
		g.gridy = 0;
		g.gridx = 0;
		add(label,g);
		g.gridx = 1;
		add(date,g);
		g.gridx = 0;
		g.gridy = 1;
		g.gridwidth = 4;
		g.gridheight = 2;
		add(scroll,g);
	}
	
}
