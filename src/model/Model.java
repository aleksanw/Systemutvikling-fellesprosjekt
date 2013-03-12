package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
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
	
	
}
