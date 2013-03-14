package server.model;

import java.sql.SQLException;
import java.sql.Time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException {
		
		User b = new User(1);
		b.delete();
		//DateTime dt = new DateTime(2014, 11, 20, 12, 15, 0, 0);
		//DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		//System.out.println(fmt.print(dt));
	}
}
