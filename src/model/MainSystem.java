package model;

import java.sql.SQLException;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException {
		User x = new User();
		x.updateField("password", "kukskalle", 0);
	}
}
