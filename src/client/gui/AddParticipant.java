package client.gui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

import common.UserI;
import common.UserListI;

class AddParticipant extends JPanel implements ActionListener {

	private JButton addP, cancel;
	private JComboBox groups;
	private JList<UserI> list;
	private JLabel lPart;
	private JScrollPane scroll;
	private DefaultListModel<UserI> model;
	private DefaultListSelectionModel selectionModel;
	private UserListI userList;
	private ArrayList<UserI> arrayUserList;
	protected ArrayList<UserI> chosenOnes;
	private Participants p;

	GridBagConstraints g = new GridBagConstraints();
	
	
	
	public AddParticipant(Participants p) {
		this.p = p;
		addP = new JButton("Legg Til..");
		addP.addActionListener(this);

		cancel = new JButton("Avbryt");
		cancel.addActionListener(this);

		groups = new JComboBox();
		try {
			groups.addItem(MainClass.sServer.groupStorage.get(1).getGroupName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}

		lPart = new JLabel();
		lPart.setText("Velg flere med shift og ctrl");
		
		selectionModel = new DefaultListSelectionModel();
		selectionModel
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		model = new DefaultListModel<UserI>();
		
		
		
		list = new JList<UserI>();
		list.setModel(model);
		list.setSelectionModel(selectionModel);
		list.setCellRenderer(new UserCellRenderer());

		scroll = new JScrollPane(list);

		try {
			userList = MainClass.sServer.userStorage.getUserList(null);
			arrayUserList = userList.getList();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		
		for (int i = 0; i < arrayUserList.size(); i++) {
			UserI user = arrayUserList.get(i);
				model.addElement(user);

		}
		setLayout(new MigLayout("wrap 1"));

		g.gridx = 0;
		g.gridy = 0;
		add(groups, "north");
		g.gridy = 1;
		add(scroll, "w 200:250:300, h 90:180:360");
		g.gridy = 2;
		add(lPart, "wrap");
		g.gridy = 3;
		add(addP, "split 2");
		g.gridx = 1;
		add(cancel);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().toString().equals("Legg Til..")) {
			chosenOnes =  (ArrayList<UserI>) list.getSelectedValuesList();
			p.addUsers(chosenOnes);
			this.setVisible(false);
		} else if (arg0.getActionCommand().toString().equals("Avbryt")) {
			this.setVisible(false);
		}
	}
}
