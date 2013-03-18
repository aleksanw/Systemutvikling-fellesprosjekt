package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import server.listModel.Rooms;
import server.model.Room;

public class Booking extends JPanel {
	
	protected JLabel label;
	protected JLabel date;
	protected JList list;
	protected JScrollPane scroll;
	server.listModel.Rooms roomList;
	DefaultListModel<Room> model;
	
	GridBagConstraints g = new GridBagConstraints();
	
	public Booking() {
		
		try {
			roomList = new Rooms();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model = new DefaultListModel<Room>();
		try {
			for(Room room: roomList.getList()){
				model.addElement(room);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(new GridBagLayout());
		
		label = new JLabel();
		label.setText("Ledige og ikke ledige rom ");
		
		date = new JLabel();
		
		list = new JList<Room>(model);
		
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
