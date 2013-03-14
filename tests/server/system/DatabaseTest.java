package server.system;

import java.sql.*;

import junit.extensions.jfcunit.JFCTestCase;

public class DatabaseTest extends JFCTestCase {
	
	/**
	 * Test database connection. Create a table, push some data, pull some data and delete table.
	 */
	public void testConnection() throws SQLException  {
		Database db = new Database();
		db.updateQuery("CREATE TABLE test_klsdjflksdjfl (" +
					"id int, " +
					"name varchar(30) " +
				");");
		
		db.updateQuery("INSERT INTO test_klsdjflksdjfl values (14, 'Noe');");
		db.updateQuery("INSERT INTO test_klsdjflksdjfl values (12, 'Hei');");
		
		ResultSet rs = db.readQuery("SELECT * FROM test_klsdjflksdjfl");
		rs.next();
		
		assertEquals(14, rs.getInt("id"));
		assertEquals("Noe", rs.getString("name"));
		
		rs.next();
		
		
		assertEquals(12, rs.getInt("id"));
		assertEquals("Hei", rs.getString("name"));
		
		assertFalse("There should be no more rows in table", rs.next());
		
		db.updateQuery("DROP TABLE test_klsdjflksdjfl;");
	}
}