package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.Driver;  // Just to check that this is imported

public class Database {
	/**
	 * Handels connection to database server.
	 * 
	 * 
	 */
	
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;
    private static String connectionURL = "jdbc:mysql://mysql.stud.ntnu.no/jonkrit_su";
    private static Statement stat = null;
    private static String user = "jonkrit_su";
    private static String pw = "kakemann";
    private static String database = "jonkrit_su";
    
    
    /**
     * Logger p� databasen.
     * @throws Exception
     */
    public Database() {
        try { //Logger inn i databasen
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(
                                connectionURL,
                                user,
                                pw);
                stat = connection.createStatement();
        } catch (Exception  ex) {
                System.out.println("Tilkobling feilet: "+ex.getMessage());
        }
    }
    
    
    /** 
     * Stenger tilkoblingen mot databasen
     * @throws SQLException
    */
    public void close() throws SQLException {
    	connection.close();
    }
    
    /**
     * SQL Query that do not alter the database. Eg. SELECT queries
     * @param sql
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet readQuery(String sql) throws SQLException {
    	Statement s = connection.createStatement();
        ResultSet rs;
        
        rs = s.executeQuery(sql);
        
        return rs;
    }
    
    /**
     * SQL Query that alters the database. Eg. CREATE TABLE, INSERT, UPDATE, DELETE querys.
     * @param sql
     * @return ResultSet
     * @throws SQLException
     */
    
    public void updateQuery(String sql) throws SQLException {
    	Statement s = connection.createStatement();
        
        s.executeUpdate(sql);
    }
    
    public Connection getConnection() throws SQLException {
    	return connection;
    }
}
