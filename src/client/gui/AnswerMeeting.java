package client.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class AnswerMeeting extends JPanel implements ActionListener {

	private JLabel header, participants, accept, decline;
	private JLabel name = new JLabel();
	private JLabel date = new JLabel();
	private JLabel place = new JLabel();
	private JLabel time = new JLabel();
	private JLabel desc = new JLabel();
	private JButton send;
	private JList list;
	private JRadioButton acc, dec;
	private JScrollPane scroll;
	private ButtonGroup myBGroup;

	GridBagConstraints g = new GridBagConstraints();

	public AnswerMeeting(String name, String date, String time, String desc,
			String place) {
		header = new JLabel();
		header.setText("Svar på innkalling");
		header.setFont(new Font("Sans Serif",Font.PLAIN,20));
		
		participants = new JLabel();
		participants.setText("Deltakere");

		accept = new JLabel();
		accept.setText("Godta");

		decline = new JLabel();
		decline.setText("Avvis");

		list = new JList();

		scroll = new JScrollPane(list);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		acc = new JRadioButton();
		acc.addActionListener(this);

		dec = new JRadioButton();
		dec.addActionListener(this);

		this.name.setText(name);
		this.date.setText(date);
		this.time.setText(time);
		this.desc.setText(desc);
		this.place.setText(place);
		
		send = new JButton("Svar");
		send.addActionListener(this);
		
		myBGroup = new ButtonGroup();
		myBGroup.add(acc);
		myBGroup.add(dec);
		
		build();
	}

	public void build(){
		setLayout(new GridBagLayout());
		
		g.gridwidth = 2;
		g.gridy = 0;
		add(header,g);
		
		g.gridy = 1;
		add(name,g);
		
		g.gridy = 2;
		add(date,g);
		
		g.gridy = 3;
		add(time,g);
		
		g.gridy = 4;
		add(desc,g);
		
		g.gridy = 5;
		add(place,g);
		
		g.gridy = 6;
		add(participants,g);
		
		g.gridy = 7;
		add(scroll,g);
		
		g.gridwidth = 1;
		g.gridy = 8;
		add(acc,g);
		add(accept,g);
		
		g.gridy = 9;
		add(dec,g);
		add(decline,g);
		
		g.gridy = 10;
		add(send,g);
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().add(new AnswerMeeting("Møte", "06.02", "15:30", "Pølsefest","Narvesen"));
		f.pack();
		f.setVisible(true);
		f.setSize(800, 600);
	}
}
