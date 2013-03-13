package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class Model {

	private static Database DB = new Database();
	private String tableName;
	private String primaryKeyField1, primaryKeyField2;
	private ArrayList<String> tableFields;
	private boolean isSavedInDB;
	private PropertyChangeSupport pcs;
	
	public Model(String tableName, ArrayList<String> tableFields, String primaryKeyField1, String primaryKeyField2) {
		this.tableName = tableName;
		this.tableFields = tableFields;
		this.primaryKeyField1 = primaryKeyField1;
		this.primaryKeyField2 = primaryKeyField2;	
	}
	
	//Zero indexed field number, value, primarykey1 and/or primarykey2
	//For easy updating of fiels for the subclass(es)
	protected void updateField(int field, Object value, int primaryKey1) throws SQLException{
		String query = "UPDATE " + tableName + " SET " + tableFields.get(field) + "='"+value.toString()+"' WHERE " +
				primaryKeyField1 + "='" + primaryKey1 + "';";
		DB.updateQuery(query);
	}
	
	protected void updateField(String field, Object value, int primaryKey1, int primaryKey2) throws SQLException{
		String query = "UPDATE " + tableName + " SET " + field + "='"+value.toString()+"' WHERE " +
				primaryKeyField1 + "='" + primaryKey1 + "' AND " + primaryKeyField2 + "='" + primaryKey2 + "';";
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
	
	protected ArrayList<Integer> addToDB(String values) throws SQLException {
		String query = "INSERT INTO " +tableName+ " (";
		int tableFieldSize = tableFields.size();
		if(tableFieldSize > 1) {
			for(int i = 1; i < tableFieldSize-1; i++) {
				query += tableFields.get(i) + ", ";
			}
		}
		query += tableFields.get(tableFieldSize-1) + ") VALUES (" + values + ");";		
		ArrayList<Integer> keyList = DB.insertAndGetKeysQuery(query);
		return keyList;
	}
	
	protected ResultSet getFromDB(int primaryKey1) throws SQLException {
		String query = "Select * FROM " + tableName + " WHERE " + primaryKeyField1 + "='" + primaryKey1 + "';";
		System.out.println(query);
		ResultSet result = DB.readQuery(query);
		return result;
	}
	
	protected ResultSet getFromDB(int primaryKey1, int primaryKey2) throws SQLException {
		String query = "Select * FROM " + tableName + " Where " + primaryKeyField1 + "='" + primaryKey1 +
				"' AND " + primaryKeyField2 + "='" + primaryKey2 + "';";
		ResultSet result = DB.readQuery(query);
		return result;
	}
	
	
}
