package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Place extends JPanel{
	
	protected JLabel lPlace;
	protected JTextField text;
	
	public Place(){
		lPlace = new JLabel();
		lPlace.setText("Sted");
		
		text = new JTextField(20);
		
		add(lPlace);
		add(text);
	}

}
