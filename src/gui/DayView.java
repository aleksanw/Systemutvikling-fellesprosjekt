package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DayView extends JPanel{
	
	private JLabel day;
	
	public DayView(String dag){
		day = new JLabel();
		day.setText(dag);
		
		setLayout(new BorderLayout());
		
		add(day,BorderLayout.NORTH);
		setPreferredSize(new Dimension(100,600));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
