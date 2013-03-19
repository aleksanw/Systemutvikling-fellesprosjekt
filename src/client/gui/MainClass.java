package client.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import server.system.StorageServer;
import client.system.StorageServerConnection;

public class MainClass {
	static JFrame frame;
	static JRootPane currentPane;
	static JPanel cards;
	static client.system.StorageServerConnection sServer;
	
	private static void swapPane(String what) {
		CardLayout layout = (CardLayout) cards.getLayout();
		layout.show(cards, what);
	}

	private static void frameSetup() {
		cards = new JPanel(new CardLayout());
		cards.add(new LoginScreen(), "login");
		cards.add(new MainScreen(), "main");
		cards.add(new AddEvent(),"addEvent");
		cards.add(new AddMeeting(),"addMeeting");
		cards.add(new GroupSettings(),"Groups");
		frame = new JFrame("G4Calender");
		frame.add(cards);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new StorageServer();
		sServer = new StorageServerConnection();
		
		System.setProperty("file.encoding", "UTF-8");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}

		CommandLine cmd = parseArgs(args);
		
		frameSetup();

		if(cmd.hasOption('L'))
			loginOK();
	}

	public static void loginOK() {
		swapPane("main");
	}
	
	public static void runAddEvent(){
		swapPane("addEvent");
	}
	
	public static void logout(){
		swapPane("login");
	}
	
	public static void runAddMeating(){
		swapPane("addMeeting");
	}
	
	public static void runGroupSettings(){
		swapPane("Groups");
	}
	
	private static CommandLine parseArgs(String[] args) {
		Options options = new Options();
		options.addOption("L", false, "Skip login-screen");
		
		try {
			return new GnuParser().parse(options, args);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
			return null; // Why the fuck do i need this shit, java?
		}
	}
}