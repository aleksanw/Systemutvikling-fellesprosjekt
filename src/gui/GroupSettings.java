package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GroupSettings extends JPanel implements ActionListener{
	private JLabel groupName, title;
	private JButton newGroup, save, cancel;
	private JTextField groupNameTF;
	private JList personList;
	private JComboBox groupsCB;
	private JScrollPane personListScroller;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	public GroupSettings(){
		title = new JLabel();
		title.setText("Gruppeinnstillinger");
		
		groupName = new JLabel();
		groupName.setText("Gruppe navn");
		
		groupNameTF = new JTextField(20);
		
		groupsCB = new JComboBox();
		
		newGroup = new JButton();
		newGroup.setText("Ny gruppe");
		newGroup.addActionListener(this);
		
		save = new JButton();
		save.setText("Lagre");
		save.addActionListener(this);
		
		cancel = new JButton();
		cancel.setText("Avbryt");
		cancel.addActionListener(this);
		
		
		personList = new JList();
		personListScroller = new JScrollPane(personList);
		
		
		setLayout(new GridBagLayout());
		gbc.gridy = 0;
		gbc.gridx = 1;
		add(title,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(groupsCB,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(newGroup,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(groupName,gbc);
		
		gbc.gridx = 1;
		add(groupNameTF,gbc);
		
		gbc.gridy= 3;
		personListScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(personListScroller,gbc);
		
		
		gbc.gridy = 4;
		gbc.gridx = 0;
		add(save, gbc);
		gbc.gridx = 1;
		add(cancel,gbc);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand().toString());
		if(e.getActionCommand().toString().equals("Lagre")){
			MainClass.loginOK();
			//Have to save the model
		}
		else if(e.getActionCommand().toString().equals("Avbryt")){
			MainClass.loginOK();
		}
		else if(e.getActionCommand().toString().equals("Ny gruppe")){
			groupNameTF.setText("");
			//Uncheck all selected people
		}
	}

}
