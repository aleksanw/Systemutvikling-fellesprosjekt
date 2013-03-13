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

public class AddParticipant extends JPanel implements ActionListener{
	
	private JButton addP,cancel;
	private JComboBox groups;
	private JList list;
	private JLabel lPart;
	private JScrollPane scroll;
	
	GridBagConstraints g = new GridBagConstraints();
	
	public AddParticipant(){
		addP = new JButton("Legg Til..");
		addP.addActionListener(this);
		
		cancel = new JButton("Avbryt");
		cancel.addActionListener(this);
		
		groups = new JComboBox();
		
		lPart = new JLabel();
		lPart.setText("Velg flere med shift og ctrl");
		
		list = new JList();
		
		scroll = new JScrollPane(list);
		
		setLayout(new GridBagLayout());
		
		g.gridx = 0;
		g.gridy = 0;
		add(groups,g);
		g.gridy = 1;
		add(scroll,g);
		g.gridy = 2;
		add(lPart,g);
		g.gridy = 3;
		add(addP,g);
		g.gridx = 1;
		add(cancel,g);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().toString().equals("Legg Til..")){
			this.setVisible(false);
			//lagre
		}
		else if(arg0.getActionCommand().toString().equals("Avbryt")){
			this.setVisible(false);
		}
	}

}
