package client.gui;

import java.rmi.RemoteException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.joda.time.DateTime;

import client.system.StorageServerConnection;

import common.EventI;
import common.UserI;

public class MainClass {
	static StorageServerConnection sServer;
	static GUI gui;
	static UserI currentUser;
	static DateTime now = DateTime.now();

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");

		CommandLine cmd = parseArgs(args);

		String srvAddr;
		if (cmd.getArgs().length < 1) {
			server.system.StartUpServer.main(new String[] {});
			srvAddr = "localhost";
		} else
			srvAddr = cmd.getArgs()[0];

		sServer = new StorageServerConnection(srvAddr);
		gui = new GUI();
		if (cmd.hasOption('L'))
			loginOK();
	}

	public static void loginOK() {
		gui.swapPane("main");
	}

	public static void runAddEvent() {
		try {
			gui.getAddEvent().setEvent(null);
		} catch (RemoteException e1) {
			throw new RuntimeException(e1);
		}
		gui.swapPane("addEvent");
		
	}
	
	public static void runChangeEvent(EventI e) {
		try {
			gui.getAddEvent().setEvent(e);
		} catch (RemoteException e1) {
			throw new RuntimeException(e1);
		}
		gui.swapPane("addEvent");
	}

	public static void logout() {
		gui.swapPane("login");
	}

	public static void runAddMeeting() {
		gui.swapPane("addMeeting");
	}

	public static void runGroupSettings() {
		gui.swapPane("Groups");
	}
	public static void runAnswerMeeting(EventI event){
		gui.swapPane("AnswerMeeting");
	}

	private static CommandLine parseArgs(String[] args) {
		Options options = new Options();
		options.addOption("L", false, "Skip login-screen");

		try {
			return new GnuParser().parse(options, args);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static UserI getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(UserI currentUser) {
		MainClass.currentUser = currentUser;
	}

}