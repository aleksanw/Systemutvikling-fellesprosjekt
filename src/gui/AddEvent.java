package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEvent extends JPanel{

	private JLabel title,lAlarm,start,end,lAllDay,lDesc,visible,lName;
	private JTextField name,desc;
	private JComboBox<String> hour,min,date,hourE,minE,dateE,alarm,group;
	private JRadioButton allDay;
	private JButton save,delete;
	private int[] hours = new int[24];
	
	GridBagConstraints g = new GridBagConstraints();
	
	public AddEvent(){
		title = new JLabel();
		title.setText("Legg til/endre alarm");
		
		lName = new JLabel();
		lName.setText("Navn:");
		
		name = new JTextField(20);
		
		start = new JLabel();
		start.setText("Start:");
		hour = new JComboBox<String>(hours);
		
		end = new JLabel();
		end.setText("Slutt:");
		
		lAllDay = new JLabel();
		lAllDay.setText("Hele dagen:");
		
		lDesc = new JLabel();
		lDesc.setText("Beskrivelse:");
		
		setLayout(new GridBagLayout());
		g.gridy = 0;
		add(title,g);
		g.gridy = 1;
		add(lName,g);
		add(name,g);
		g.gridy = 2;
		add(start,g);
		add(hour,g);
		
		g.gridy = 3;
		add(end,g);
		g.gridy = 4;
		add(lAllDay,g);
		g.gridy = 5;
		add(lDesc,g);
	}
	
	
}
