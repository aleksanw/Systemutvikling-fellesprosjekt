package client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.joda.time.DateTime;

import common.EventI;

@SuppressWarnings("unused")
class DayView extends JPanel implements ListSelectionListener {

	private JLabel day;
	private DateTime date;
	private JList<EventI> list;
	private JScrollPane scroll;
	protected DefaultListModel model;
	private DefaultListSelectionModel selectionModel;

	public DayView(String dag) {
		day = new JLabel();
		day.setText(dag);

		model = new DefaultListModel();
		
		selectionModel = new DefaultListSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		list = new JList<EventI>(model);
		list.setCellRenderer(new EventCellRenderer());
		list.addListSelectionListener(this);
		list.setSelectionModel(selectionModel);

		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		setLayout(new BorderLayout());

		add(day, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);

		setPreferredSize(new Dimension(150, 650));
	}

	public void valueChanged(ListSelectionEvent e) {
		MainClass.runChangeEvent(list.getSelectedValue());
		list.setSelectedIndex(0);
	}
	
	
}
