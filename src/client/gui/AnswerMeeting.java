package client.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import common.EventI;
import common.InvitationI;

class AnswerMeeting extends JPanel implements ActionListener {

	private JLabel header, accept, decline;
	private JLabel name = new JLabel();
	private JLabel date = new JLabel();
	private JLabel time = new JLabel();
	private JButton send, cancel;
	private JRadioButton acc, dec;
	private ButtonGroup myBGroup;
	private EventI selectedEvent;
	private InvitationI invite;
	
	public void setSelectedEvent(EventI selectedEvent) {
		this.selectedEvent = selectedEvent;
		try {
			this.name.setText(selectedEvent.getEventName());
			DateTimeFormatter FMT = DateTimeFormat.forPattern("HH-mm dd-MM-yyyy");
			this.date.setText(FMT.print(selectedEvent.getStart()));
			this.time.setText(FMT.print(selectedEvent.getEnd()));
		} catch (RemoteException e2) {
			throw new RuntimeException(e2);
		}
	}

	public void setInvite(InvitationI invite) {
		this.invite = invite;
	}


	GridBagConstraints g = new GridBagConstraints();

	public AnswerMeeting() {
		header = new JLabel();
		header.setText("Svar på innkalling");
		header.setFont(new Font("Sans Serif", Font.PLAIN, 20));

	

		accept = new JLabel();
		accept.setText("Godta");

		decline = new JLabel();
		decline.setText("Avvis");

		


		acc = new JRadioButton();
		acc.addActionListener(this);

		dec = new JRadioButton();
		dec.addActionListener(this);

		send = new JButton("Svar");
		send.addActionListener(this);
		
		cancel = new JButton("Avbryt");
		cancel.addActionListener(this);

		myBGroup = new ButtonGroup();
		myBGroup.add(acc);
		myBGroup.add(dec);

		build();
	}

	public void build() {
		setLayout(new GridBagLayout());

		g.gridwidth = 2;
		g.gridy = 0;
		add(header, g);

		g.gridy = 1;
		add(name, g);

		g.gridy = 2;
		add(date, g);

		g.gridy = 3;
		add(time, g);

		g.gridwidth = 1;
		g.gridy = 4;
		add(acc, g);
		add(accept, g);

		g.gridy = 5;
		add(dec, g);
		add(decline, g);

		g.gridy = 6;
		add(send, g);
		
		g.gridx = 1;
		add(cancel, g);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().toString().equals("Svar")){
			
			
		}
		else if (e.getActionCommand().toString().equals("Avbryt")){
			MainClass.loginOK();
		}

	}

}
