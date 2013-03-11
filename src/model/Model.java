package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
	
	protected void updateField(String field, Object value){
		
	}
	
	public void addPropartyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropartyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
	
}
