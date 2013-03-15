package client.gui;

import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("unused")
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
