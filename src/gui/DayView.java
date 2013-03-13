package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.joda.time.DateTime;


public class DayView extends JPanel{
	
	private JLabel day;
	private DateTime date;
	private Event evt;
	private JList<String> list;
	private JScrollPane scroll;
	
	public DayView(String dag){
		day = new JLabel();
		day.setText(dag);
		
		list = new JList<String>();
		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		setLayout(new BorderLayout());
		
		add(day,BorderLayout.NORTH);
		add(scroll,BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
	
	public void addEvents(){
		
	}
	
	public void findPos(DateTime date){
		int startPos = date.getHourOfDay() + date.getMinuteOfDay();
		
	}
}
