package server.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Database {
	/**
	 * Handels connection to database server.
	 * 
	 * 
	 */
	
    private static Connection connection = null;
    private static String connectionURL = "jdbc:mysql://mysql.stud.ntnu.no/jonkrit_su";
	private static Statement stat = null;
    private static String user = "jonkrit_su";
    private static String pw = "kakemann";
    private static String database = "jonkrit_su";
    
    
    /**
     * Logger på databasen.
     * @throws Exception
     */
    public Database() {
        try { //Logger inn i databasen
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
     * @throws SQLException
     */
    
    public void updateQuery(String sql) throws SQLException {
    	Statement s = connection.createStatement();
        
        s.executeUpdate(sql);
    }
    
    /**
     * SQL Query that INSERT in the DB and return the keys
     * @param sql
     * @return keylist
     * @throws SQLException
     */
    public ArrayList<Integer> insertAndGetKeysQuery(String sql) throws SQLException {
    	Statement s = connection.createStatement();
        s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet keys = s.getGeneratedKeys();
        ArrayList<Integer> keyList = new ArrayList<Integer>();
        int i = 1;
        while(keys.next()) {
        	keyList.add(keys.getInt(i));
        	i++;
        }
    	return keyList;
    }
    
    public Connection getConnection() throws SQLException {
    	return connection;
    }
}
