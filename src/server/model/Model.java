package server.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.system.Database;

public abstract class Model {

	private static Database DB = new Database();
	private String tableName;
	private String primaryKeyField1;
	private ArrayList<String> tableFields;
	private PropertyChangeSupport pcs;
	
	
	public Model(String tableName, ArrayList<String> tableFields, String primaryKeyField1) {
		this.tableName = tableName;
		this.tableFields = tableFields;
		this.primaryKeyField1 = primaryKeyField1;
	}
	
	public abstract void delete() throws SQLException;
	
	protected void delete(int ID) throws SQLException {
		DB.updateQuery("DELETE FROM " + tableName + " WHERE userID=" + ID);
	}

	protected void updateField(String field, Object value, int primaryKey1) throws SQLException{
		String c =((value instanceof String) ? ( "'" +value+"'" ) : value.toString());
		String query = "UPDATE " + tableName + " SET " + field + "="+ c +" WHERE " +
				primaryKeyField1 + "=" + primaryKey1 + ";";
		DB.updateQuery(query);
	}
	
	
	public void addPropartyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropartyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	protected ArrayList<String> getTableFields() {
		return tableFields;
	}
	
	protected ArrayList<Integer> addToDB() throws SQLException {
		String query = "INSERT INTO " + tableName + " () VALUES ();";		
		ArrayList<Integer> keyList = DB.insertAndGetKeysQuery(query);
		return keyList;
	}
	
	protected ResultSet getFromDB(int primaryKey1) throws SQLException {
		String query = "Select * FROM " + tableName + " WHERE " + primaryKeyField1 + "='" + primaryKey1 + "';";
		ResultSet result = DB.readQuery(query);
		return result;
	}
	
	protected Database getDB() {
		return DB;
	}
}
