package gui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainClass {
	static JFrame frame;
	static JRootPane currentPane;
	static JPanel cards;
	
	private static void swapPane(String what) {
		CardLayout layout = (CardLayout) cards.getLayout();
		layout.show(cards, what);
	}

	private static void frameSetup() {
		cards = new JPanel(new CardLayout());
		cards.add(new Login(), "login");
		cards.add(new MainScreen(), "main");
		cards.add(new AddEvent(),"addEvent");
		cards.add(new AddMeating(),"addMeating");
		cards.add(new GroupSettings(),"Groups");
		frame = new JFrame("Login");
		frame.add(cards);
		frame.setSize(1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/**try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}**/
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		frameSetup();
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
		swapPane("addMeating");
	}
	
	public static void runGroupSettings(){
		swapPane("Groups");
	}
}