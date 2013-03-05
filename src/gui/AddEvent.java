package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddEvent extends JPanel implements ActionListener{

	private JLabel title,lAlarm,start,end,lAllDay,lDesc,visible,lName;
	private JTextField name;
	private JTextArea desc;
	private JComboBox<String> hour,min,date,hourE,minE,dateE,alarm,group,vis;
	private JRadioButton allDay;
	private JButton save,delete;
	
	GridBagConstraints g = new GridBagConstraints();
	
	public AddEvent(){
		String[] hours = addNum(24);
		String[] minutes = {"00","15","30","45"};
		String[] minForAlarm = {"Ingen alarm","10 min","15 min","20 min", "30 min", "1 time","2 timer", "24 timer"};
		
		title = new JLabel();
		title.setText("Legg til/endre alarm");
		
		lName = new JLabel();
		lName.setText("Navn:");
		
		name = new JTextField(20);
		
		start = new JLabel();
		start.setText("Start:");
		hour = new JComboBox<String>(hours);
		min = new JComboBox<String>(minutes);
		
		end = new JLabel();
		end.setText("Slutt:");
		hourE = new JComboBox<String>(hours);
		minE = new JComboBox<String>(minutes);
		
		lAllDay = new JLabel();
		lAllDay.setText("Hele dagen:");
		allDay = new JRadioButton();
		allDay.addActionListener(this);
		
		lDesc = new JLabel();
		lDesc.setText("Beskrivelse:");
		desc = new JTextArea(5,20);
		
		lAlarm = new JLabel();
		lAlarm.setText("Legg Til Alarm:");
		alarm = new JComboBox<String>(minForAlarm);
		
		save = new JButton();
		save.setText("Lagre");
		save.addActionListener(this);
		
		delete = new JButton();
		delete.setText("Slett");
		delete.addActionListener(this);
		
		visible = new JLabel();
		visible.setText("Synlig for:");
		vis = new JComboBox<String>();
		
		
		
		setLayout(new GridBagLayout());
		g.gridy = 0;
		g.gridx = 1;
		add(title,g);
		
		g.gridx = 0;
		g.gridy = 1;
		add(lName,g);
		g.gridx = 1;
		add(name,g);
		
		g.gridx = 0;
		g.gridy = 2;
		add(start,g);
		g.gridx = 1;
		add(hour,g);
		g.gridx = 2;
		add(min,g);
		
		g.gridx = 0;
		g.gridy = 3;
		add(end,g);
		g.gridx = 1;
		add(hourE,g);
		g.gridx = 2;
		add(minE,g);
		
		g.gridx = 0;
		g.gridy = 4;
		add(lAllDay,g);
		g.gridx = 1;
		add(allDay,g);
		
		g.gridx = 0;
		g.gridy = 5;
		add(lDesc,g);
		g.gridx = 1;
		add(desc,g);
		
		g.gridy = 6;
		g.gridx = 0;
		add(lAlarm,g);
		g.gridx = 1;
		add(alarm,g);
		
		g.gridy = 7;
		g.gridx = 0;
		add(visible,g);
		g.gridx = 1; 
		add(vis,g);
		
		g.gridy = 8;
		g.gridx = 0;
		add(save,g);
		g.gridx = 1;
		add(delete,g);
		
	}
	
	public String[] addNum(int i){
		String[] resList = new String[i];
		for (int j = 0; j < i; j++) {
			resList[j] = Integer.toString(j);
		}
		return resList;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
		if(e.getActionCommand().toString().equals("Lagre")){
			MainClass.loginOK();
		}
		else if(allDay.isSelected()){
			hourE.setEnabled(false);
			minE.setEnabled(false);
		}
		else if(!allDay.isSelected()){
			hourE.setEnabled(true);
			minE.setEnabled(true);
		}
	}
}
