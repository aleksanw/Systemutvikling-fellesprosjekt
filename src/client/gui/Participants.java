package client.gui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import common.EventI;
import common.UserI;
import common.UserListI;

class Participants extends JPanel implements ActionListener {

	protected JButton findP;
	protected JList<UserI> part;
	protected JScrollPane scroll;
	protected JLabel lPart;
	protected AddParticipant adder;
	protected DefaultListModel<UserI> model;
	protected UserListI users;
	protected ArrayList<UserI> addedUsers;
	protected EventI event;

	GridBagConstraints g;

	public Participants() {
		g = new GridBagConstraints();
		findP = new JButton("Legg til Deltaker");
		findP.addActionListener(this);

		model = new DefaultListModel<UserI>();
		addedUsers = new ArrayList<UserI>();
		part = new JList<UserI>(model);
		part.setCellRenderer(new UserCellRenderer());
		
		scroll = new JScrollPane(part);
		lPart = new JLabel();
		lPart.setText("Deltakere");
		
		adder = new AddParticipant(this);
		setLayout(new MigLayout("wrap 1"));

		g.gridy = 0;
		add(lPart, "");
		g.gridy = 1;
		add(findP, "");
		g.gridy = 2;
		add(scroll, "w 200:250:300, h 90:180:360");
		g.gridy = 3;
		g.gridx = 0;
		g.gridheight = 4;
		g.gridwidth = 2;
		add(adder, "w 200:250:300, h 90:180:360");
		adder.setVisible(false);

	}

	public void addUsers(ArrayList<UserI> users) {
		boolean isEqual;
		for(UserI user : users) {
			try {
				if(!addedUsers.contains(user) && user.getUserID() != MainClass.getCurrentUser().getUserID()) {
					isEqual = false;
					for(UserI userInList : addedUsers) {
						if(user.getUserID() == userInList.getUserID()) {
							isEqual = true;
						}
					}
					if(!isEqual) {
						this.addedUsers.add(user);
						this.model.addElement(user);
					}
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}
	
	public void setAddedUsers(ArrayList<UserI> users) {
		this.addedUsers = new ArrayList<UserI>();
		this.model.clear();
		System.out.println("users");
		this.addUsers((ArrayList<UserI>) users);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().toString().equals("Legg til Deltaker")) {
			adder.setVisible(true);
		}
	}
	
	public ArrayList<UserI> getAddedUsers() {
		return this.addedUsers;
	}

	public void setEvent(EventI event) {
		this.event = event;
	}
	
}
