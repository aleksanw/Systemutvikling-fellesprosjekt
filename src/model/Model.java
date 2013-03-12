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
	
	public Model(String tableName, ArrayList<String> tableFields) {
		this.tableName = tableName;
		this.tableFields = tableFields;
	}
	
	protected void updateField(String field, Object value, int primaryKey) throws SQLException{
		System.out.println("UPDATE " + tableName + " SET " + field + "="+value.toString()+";");
		DB.updateQuery("UPDATE " + tableName + " SET " + field + "='"+value.toString()+"' WHERE " +
		primaryKeyField1 + "=" + primaryKey + ";");
	}
	
	public void addPropartyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropartyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
}
