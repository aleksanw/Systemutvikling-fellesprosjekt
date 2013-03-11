package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    private static String pw = "kakemann!";
    private static String database = "jonkrit_su";
    
    
    /**
     * Logger på databasen.
     * @throws Exception
     */
    public Database() throws Exception {
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
    
    public ResultSet query(String sql) throws SQLException {
    	Statement s = connection.createStatement();
        ResultSet rs;
        
        rs = s.executeQuery(sql);
        
        return rs;
    }
    
    public Connection getConnection() throws SQLException {
    	return connection;
    }
}
