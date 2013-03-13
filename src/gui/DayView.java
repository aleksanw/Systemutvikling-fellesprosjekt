package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.joda.time.DateTime;


public class DayView extends JPanel{
	
	private JLabel day;
	private DateTime date;
	private Event evt;
	private JButton evt2;
	
	public DayView(String dag){
		day = new JLabel();
		day.setText(dag);
		
		setLayout(new BorderLayout());
		
		add(day,BorderLayout.NORTH);
		setPreferredSize(new Dimension(100,600));
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
	
	public void addEvents(){
		/**evt = new Event();
		add(evt);**/
		evt2 = new JButton();
		evt2.setText("Viktig");
		add(evt2);
		evt2.setSize(100, 100);
		evt2.setLocation(0, 50);
	}
	
	public void findPos(DateTime date){
		int startPos = date.getHourOfDay() + date.getMinuteOfDay();
		
	}
}
