package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.joda.time.DateTime;


public class DayView extends JPanel implements ListSelectionListener{
	
	private JLabel day;
	private DateTime date;
	private Event evt;
	private JList<String> list;
	private JScrollPane scroll;
	private DefaultListModel model;
	
	public DayView(String dag){
		day = new JLabel();
		day.setText(dag);
		
		model = new DefaultListModel<>();
		
		list = new JList<String>(model);
		list.setCellRenderer(new CellRenderer());
		list.addListSelectionListener(this);
		
		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		setLayout(new BorderLayout());
		
		add(day,BorderLayout.NORTH);
		add(scroll,BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(150,650));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
	
	public void addEvents(){
		
	}
	
	public void findPos(DateTime date){
		int startPos = date.getHourOfDay() + date.getMinuteOfDay();
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
