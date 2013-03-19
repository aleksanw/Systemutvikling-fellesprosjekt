package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import server.listModel.Rooms;

import common.RoomI;
import common.RoomsI;

public class Booking extends JPanel {

	protected JLabel label;
	protected JLabel date;
	protected JList<RoomI> list;
	protected JScrollPane scroll;
	protected RoomsI roomList;
	protected DefaultListModel<RoomI> model;
	protected DefaultListSelectionModel selectionModel;

	GridBagConstraints g = new GridBagConstraints();

	@SuppressWarnings("unchecked")
	public Booking() {
		roomList = new Rooms();
		model = new DefaultListModel<RoomI>();
		for (RoomI room : roomList.getList()) {
			model.addElement(room);
		}

		setLayout(new GridBagLayout());

		label = new JLabel();
		label.setText("Ledige og ikke ledige rom ");

		date = new JLabel();

		selectionModel = new DefaultListSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		list = new JList<RoomI>(model);
		list.setSelectionModel(selectionModel);
		list.setCellRenderer(new CellRenderer());

		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		g.fill = GridBagConstraints.BOTH;
		g.gridy = 0;
		g.gridx = 0;
		add(label, g);
		g.gridx = 1;
		add(date, g);
		g.gridy = 1;
		add(scroll, g);
	}
}
