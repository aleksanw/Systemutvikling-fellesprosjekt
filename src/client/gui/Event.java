package client.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import server.model.Model;


public class Event extends JPanel{
	
	private String desc,place,text,name;
	private ArrayList<String> fields;
	
	public Event(String d, String p, String name, int sH, int sM, int eH, int eM){	
		fields.add(p);
		fields.add(d);
		//Model.Event(name,fields,);
		
	}
	
	public String toString() {
		return text;
	}
}
