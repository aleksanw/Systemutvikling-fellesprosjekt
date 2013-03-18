package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.rmi.RemoteException;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import server.listModel.Rooms;
import server.model.Room;

public class Booking extends JPanel {
	
	protected JLabel label;
	protected JLabel date;
	protected JList<Room> list;
	protected JScrollPane scroll;
	protected server.listModel.Rooms roomList;
	protected DefaultListModel<Room> model;
	protected DefaultListSelectionModel selectionModel;
	
	GridBagConstraints g = new GridBagConstraints();
	
	@SuppressWarnings("unchecked")
	public Booking() {
		try {
			roomList = new Rooms();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model = new DefaultListModel<Room>();
		try {
			for(Room room: roomList.getList()){
				model.addElement(room);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		setLayout(new GridBagLayout());
		
		label = new JLabel();
		label.setText("Ledige og ikke ledige rom ");
		
		date = new JLabel();
		
		selectionModel = new DefaultListSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list = new JList<Room>(model);
		list.setSelectionModel(selectionModel);
		list.setCellRenderer(new CellRenderer());
		
		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		g.fill = GridBagConstraints.BOTH;
		g.gridy = 0;
		g.gridx = 0;
		add(label,g);
		g.gridx = 1;
		add(date,g);
		g.gridy = 1;
		add(scroll,g);
	}
}