package client.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;


public class Sidebar extends JPanel {
	
	private JLabel recieved, sent, calenders;
	private JList rList, sList;
	private JScrollPane sScroll,rScroll;
	private String[] list = {"t1","t2","t3"};
	
	public Sidebar(){
		recieved = new JLabel("Mottatte Møteinnkallelser");
		rList = new JList();
		//rList.setCellRenderer(new CellRenderer());
		rScroll = new JScrollPane(rList);
		rScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		sent = new JLabel("Sendte Møteinnkallelser");
		sList = new JList();
		sScroll = new JScrollPane(sList);
		sScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		calenders = new JLabel("Kalendre");
		
		setLayout(new MigLayout("wrap 1"));
		add(recieved);
		add(rScroll);
		add(sent);
		add(sScroll);
		add(calenders);
		
		//setPreferredSize(new Dimension(250,600));
	}
}