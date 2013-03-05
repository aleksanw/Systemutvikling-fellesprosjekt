package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Buttons extends JPanel implements ActionListener{
	
	private JButton event, meating, groups, logout, rArrow,lArrow;
	private JLabel curWeek;
	
	GridBagConstraints gbc = new GridBagConstraints();

	public Buttons(){
		event = new JButton("Legg Til Avtale");
		event.addActionListener(this);
		
		meating = new JButton("Kall Inn Til Møte");
		meating.addActionListener(this);
		
		groups = new JButton("Gruppeinnstillinger");
		groups.addActionListener(this);
		
		curWeek = new JLabel();
		curWeek.setText("Uke 6, 2013");
		
		rArrow = new JButton(">");
		rArrow.addActionListener(this);
		
		lArrow = new JButton("<");
		lArrow.addActionListener(this);
		
		logout = new JButton("Logg Ut");
		logout.addActionListener(this);
		
		setLayout(new GridBagLayout());
		gbc.gridy = 0;
		add(event,gbc);
		add(meating,gbc);
		add(groups,gbc);
		add(curWeek,gbc);
		add(lArrow,gbc);
		add(rArrow,gbc);
		add(logout,gbc);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().toString().equals("Legg Til Avtale")){
			MainClass.runAddEvent();
		}
	}
}
